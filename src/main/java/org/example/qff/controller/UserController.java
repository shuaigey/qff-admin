package org.example.qff.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ResponseHeader;
import org.apache.ibatis.annotations.Param;
import org.example.qff.common.result.QffResponse;
import org.example.qff.entity.Role;
import org.example.qff.entity.User;
import org.example.qff.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/2 15:16
 * 用户
 **/
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    /*注册用户*/
    @PostMapping("/register")
    public QffResponse registerUser(@RequestBody User userParam) {
        return userService.registerUser(userParam);
    }
    /*登录用户*/
    @PostMapping("/login")
    public QffResponse loginUser(@RequestBody User userParam) {
        return userService.loginUser(userParam);
    }
    /*新增角色权限*/
    @PostMapping("/insertRole")
    public QffResponse insertRole(@RequestBody Role roleParam) {
        return userService.insertRole(roleParam);
    }
    /*修改角色信息*/
    @PostMapping("/updateRole")
    public QffResponse updateRole(@RequestBody Role roleParam) {
        return userService.updateRole(roleParam);
    }

    /*根据登录人查询个人信息*/
    @GetMapping("/getToken")
    public QffResponse getToken(@RequestParam("token") String token){
        return userService.getToken(token);
    }

}
