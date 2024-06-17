package org.example.qff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/19 9:30
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("role_name")
    private String roleName;

    @TableField("menu_id")
    private String menuId;

    @TableField("code")
    private String code;

    @TableField("status")
    private Integer status;

    @TableField("delete_status")
    private Integer deleteStatus;

    @TableField("update_time")
    private String updateTime;

    @TableField("role_code")
    private Integer roleCode;





}
