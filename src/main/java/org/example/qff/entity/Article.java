package org.example.qff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

/**
 * @Author：liufan
 * @Package：org.example.qff.entity
 * @Project：qff-admin
 * @name：Article
 * @Date：2025/4/8 14:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class Article {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @TableField("status")
    private Integer status;

    @TableField("title")
    private String title;

    @TableField("context")
    private String context;

    @TableField("Img_url")
    private String ImgUrl;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;

    @TableField("delete_status")
    private Integer deleteStatus;

}

