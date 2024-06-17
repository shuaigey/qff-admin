package org.example.qff.service;

import org.example.qff.common.result.QffResponse;
import org.example.qff.entity.Role;
import org.example.qff.entity.User;


/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/5 8:12
 **/

public interface UserService {

     /*注册用户*/
     QffResponse registerUser(User param);
     /*登录用户*/
     QffResponse loginUser(User param);
     /*新增角色权限*/
     QffResponse insertRole(Role roleParam);
     /*修改角色信息*/
     QffResponse updateRole(Role roleParam);
}
