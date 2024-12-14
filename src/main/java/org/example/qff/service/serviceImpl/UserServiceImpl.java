package org.example.qff.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.qff.common.result.ErrorCode;
import org.example.qff.common.result.QffResponse;
import org.example.qff.common.result.ResultUtils;
import org.example.qff.common.util.*;
import org.example.qff.dao.RoleMapper;
import org.example.qff.dao.UserMapper;
import org.example.qff.entity.Role;
import org.example.qff.entity.User;
import org.example.qff.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/5 8:13
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;


    @Resource
    private RedisTemplate  redisTemplate;


    @Override
    public QffResponse registerUser(User param) {
        if (!StringUtils.isEmpty(param.getPhone()) && !StringUtils.isEmpty(param.getPassword())) {
            User user = userMapper.selectByPhone(param.getPhone());
            if (ObjectUtils.isEmpty(user)) {
                param.setUserId(GetUtil.getId());
                param.setRegisterTime(TimeUtil.nowTime());
                param.setPassword(MD5Util.generateSaltPassword(param.getPassword()));
                userMapper.insert(param);
                return ResultUtils.success(ConstantUtil.REGISTER_SUCCESS);
            }
            return ResultUtils.error(ErrorCode.SYSTEM_ERROR, ConstantUtil.REGISTER_ERROR1);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR, ConstantUtil.REGISTER_ERROR2);
    }

    @Override
    public QffResponse loginUser(User param) {
        if (StringUtils.isEmpty(param.getPhone()) || StringUtils.isEmpty(param.getPassword())) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR, ConstantUtil.LOGIN_ERROR);
        }
        User user = userMapper.selectByPhone(param.getPhone());
        if(ObjectUtils.isEmpty(user)){
            return ResultUtils.error(ErrorCode.NO_LOGIN, ConstantUtil.ROLE_ERROR);
        }
        //获取该用户在数据库里面的加密过的密码
        String saltPassword = user.getPassword();
        //输入的密码和加密后的密码进行比较
        boolean passwordFlag = MD5Util.verifySaltPassword(param.getPassword(), saltPassword);
        if (!passwordFlag || !user.getPhone().equals(param.getPhone())) {
            return ResultUtils.error(ErrorCode.LOGIN_ERROR, ConstantUtil.LOGIN_ERROR);
        }

        redisTemplate.opsForValue().set(param.getPhone(),param.getPassword());
        //登录
        if (passwordFlag && user.getPhone().equals(param.getPhone())) {
            user.setLastLoginTime(TimeUtil.nowTime());
            //获取登陆token
            Map<String,Object> map=new HashMap<>();
            map.put("id",user.getUserId());
            map.put("username",user.getUserName());
            String creatJwt = JwtUtil.creatJwt(map);
            System.out.print(creatJwt);
            userMapper.updateById(user);
            return ResultUtils.success(creatJwt,ConstantUtil.LOGIN_SUCCESS);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR, ConstantUtil.LOGIN_ERROR);
    }

    @Override
    public QffResponse insertRole(Role roleParam) {
        roleParam.setUpdateTime(TimeUtil.nowTime());
        if (StringUtils.isEmpty(roleParam.getRoleName())){
            return ResultUtils.error(ErrorCode.NULL_ERROR,ConstantUtil.ERROR);
        }
        roleParam.setCode(GetUtil.getPinYinHeadChar(roleParam.getRoleName()));
        roleMapper.insert(roleParam);
        return ResultUtils.success(ConstantUtil.SUCCESS);
    }

    @Override
    public QffResponse updateRole(Role roleParam) {
        Role role = roleMapper.selectById(roleParam.getId());
        role.setRoleCode(roleParam.getRoleCode());
        role.setRoleName(roleParam.getRoleName());
        role.setUpdateTime(TimeUtil.nowTime());
        role.setMenuId(roleParam.getMenuId());
        role.setCode(GetUtil.getPinYinHeadChar(roleParam.getRoleName()));
        roleMapper.updateById(role);
        return ResultUtils.success(role);
    }

    @Override
    public QffResponse getToken(String token) {
        /*解析token*/
        Map<String, Object> tokenMap = JwtUtil.parseJwt(token);
        String id = (String) tokenMap.get("id");
        /*  查询登录人信息*/
        if (StringUtils.isEmpty(id)){
            return ResultUtils.error(ErrorCode.NULL_ERROR,ConstantUtil.ERROR);
        }
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("user_id",id);
        User user = userMapper.selectList(userQueryWrapper).get(0);
        return ResultUtils.success(user);
    }
}

