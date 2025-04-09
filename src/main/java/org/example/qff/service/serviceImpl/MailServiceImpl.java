package org.example.qff.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.qff.common.util.MailUtil;
import org.example.qff.service.MailService;
import org.example.qff.vo.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/11/26 16:40
 **/
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Resource
    private Mail mail;
    @Override
    public boolean send(String to, String title, String content) {
       log.info("data:",mail);
        Boolean flag= MailUtil.sendMail(mail,to,title,content);
        return flag;
    }
}
