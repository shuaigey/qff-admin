package org.example.qff.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/11/26 16:18
 **/
@Component
@ConfigurationProperties(prefix = "email")
public class Mail {
    //发件人邮箱
    public String user;
    //发件人授权码
    public String code;
    //邮箱类型163/qq
    public String host;
    //身份验证开关
    public Boolean auth;


}
