package com.example.sl_tech.Utils.Inteface;

import org.springframework.stereotype.Component;

@Component
public interface EmailSender {
    /**
     * 发送文本邮件
     * */
    void sendSimpleEmail(String to, String subject, String content);
    void sendHtmlEmail(String to ,String subject,String content);

    void sendHtmlEmail();
}
