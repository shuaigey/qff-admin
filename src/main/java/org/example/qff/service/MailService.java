package org.example.qff.service;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/11/26 16:39
 **/
public interface MailService {

    boolean send(String to,String title,String content);
}
