package org.example.qff.controller;

import io.swagger.annotations.Api;
import org.example.qff.common.result.QffResponse;
import org.example.qff.entity.Menu;
import org.example.qff.param.MenuParam;
import org.example.qff.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/14 10:31
 **/
@Api(tags = "菜单")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    MenuService menuService;
    /*新增菜单*/
    @PostMapping("/insertMenu")
    public QffResponse insertMenu(@RequestBody MenuParam menuParam ) {
        return menuService.insertMenu(menuParam);
    }
    /*查询菜单*/
    @GetMapping("/selectAll")
    public QffResponse<List<Menu>> selectMenu(@RequestParam("userId") String userId){
        return menuService.selectMenu(userId);
    }
    /*修改菜单信息*/
    @PostMapping("/updateMenu")
    public QffResponse updateMenu(@RequestBody Menu menuParam){
        return menuService.updateMenu(menuParam);
    }



}
