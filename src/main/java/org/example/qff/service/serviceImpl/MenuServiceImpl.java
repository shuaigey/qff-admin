package org.example.qff.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.qff.common.result.ErrorCode;
import org.example.qff.common.result.QffResponse;
import org.example.qff.common.result.ResultUtils;
import org.example.qff.common.util.GetUtil;
import org.example.qff.dao.MenuMapper;
import org.example.qff.dao.RoleMapper;
import org.example.qff.dao.UserMapper;
import org.example.qff.entity.Menu;

import org.example.qff.entity.Role;
import org.example.qff.param.MenuParam;
import org.example.qff.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.qff.common.util.ConstantUtil.*;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/15 8:33
 **/
@Slf4j
@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;



    @Resource
    RoleMapper roleMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public QffResponse insertMenu(MenuParam menuParam) {
        Menu menu = new Menu();
        if (StringUtils.isEmpty(menuParam.getName())) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        menu.setName(menuParam.getName());
        menu.setReferred(GetUtil.getPinYinHeadChar(menuParam.getName()));
        if (StringUtils.isEmpty(menuParam.getPId())) {
            menu.setPId(ZERO_I);
        } else {
            menu.setPId(menuParam.getPId());
        }
        menuMapper.insert(menu);
        return ResultUtils.success(SUCCESS);
    }

    @Override
    public QffResponse<List<Menu>> selectMenu(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return ResultUtils.error(ErrorCode.NULL_ERROR);
        }
        //查询用户角色
        String roleId = userMapper.selectByUserId(userId);
        if (StringUtils.isEmpty(roleId)) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        Role role = roleMapper.selectById(roleId);
        //查询角色对应的菜单
        String menuId = role.getMenuId();
        List<String> menuIds = Arrays.asList(menuId.split(","));
        List<Menu> menus = menuMapper.selectByMenuIds(menuIds);
        log.info("data{}", menus);
        Map<Integer, List<Menu>> map = menus.stream().collect(Collectors.groupingBy(Menu::getPId));
        log.info("buildTree{}", map);
        menus.forEach(s -> {
                    List<Menu> menuList = map.get(s.getId());
                    if (null == menuList || menuList.size() == ZERO_I) {
                        s.setListMenu(new ArrayList<>());
                    } else {
                        s.setListMenu(menuList);
                    }
                }
        );
        //
        List<Menu> collect = menus.stream().filter(s -> s.getPId() == ZERO_I).collect(Collectors.toList());
        return ResultUtils.success(collect);
    }

    @Override
    public QffResponse updateMenu(Menu menuParam) {
        if(StringUtils.isEmpty(menuParam.getId())){
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        Menu menu = menuMapper.selectById(menuParam.getId());
        menu.setStatus(menuParam.getStatus());
        menu.setName(menuParam.getName());
        menuMapper.updateById(menu);
        return ResultUtils.success(SUCCESS);
    }
}
