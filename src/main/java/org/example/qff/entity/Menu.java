package org.example.qff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/15 15:02
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("menu")
public class Menu {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("pid")
    private Integer pId;

    @TableField("name")
    private String name;

    @TableField("delete_status")
    private Integer deleteStatus;

    @TableField("status")
    private Integer status;

    @TableField("referred")
    private String referred;

//   菜单数据
    @TableField(exist = false)
    private List<Menu> ListMenu;

}
