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

    QffResponse insertMenu(MenuParam menuParam);

    QffResponse<List<Menu>> selectMenu(String userId);

    QffResponse updateMenu(Menu menuParam);
}
