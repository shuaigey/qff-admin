package org.example.qff.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/5 11:02
 **/
@Data
public class MenuParam {
    @ApiModelProperty(value = "id")
    private Integer pId;

    @ApiModelProperty(value = "名字")
    private String name;


}
