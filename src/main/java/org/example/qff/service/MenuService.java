package org.example.qff.service;

import org.example.qff.common.result.QffResponse;
import org.example.qff.entity.Menu;
import org.example.qff.entity.User;
import org.example.qff.param.MenuParam;

import java.util.List;
import java.util.Map;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/15 8:32
 **/
public interface MenuService {
    /*新增菜单*/
    QffResponse insertMenu(MenuParam menuParam);
    /*查询菜单*/
    QffResponse<List<Menu>> selectMenu(String userId);
    /*修改菜单信息*/
    QffResponse updateMenu(Menu menuParam);
}
