package org.example.qff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/5 7:59
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String userName;

    @TableField("number")
    private String number;

    @TableField("password")
    private String password;

    @TableField("user_id")
    private String userId;

    @TableField("dept_id")
    private String deptId;

    @TableField("phone")
    private String phone;

    @TableField("register_time")
    private String registerTime;

    @TableField("last_login_time")
    private String lastLoginTime;

    @TableField("status")
    private String status;


}
