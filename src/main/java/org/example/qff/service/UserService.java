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


     QffResponse registerUser(User param);

     QffResponse loginUser(User param);

     QffResponse insertRole(Role roleParam);

     QffResponse updateRole(Role roleParam);
}
