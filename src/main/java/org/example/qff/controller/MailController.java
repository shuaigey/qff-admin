package org.example.qff.controller;

import io.swagger.annotations.Api;
import org.example.qff.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/11/26 16:53
 **/
@Api(tags = "邮件")
@RequestMapping("/mail")
@RestController
public class MailController {

    @Resource
    MailService mailService;

    @RequestMapping("/send")
    public Boolean send() {
        String to = "2722775123@qq.com";
        String title = "测试短信";
        String content = "11111111111111111111";
        Boolean flag = mailService.send(to, title, content);
        return flag;
    }
}
