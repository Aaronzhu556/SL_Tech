package com.example.sl_tech.Utils;

import com.example.sl_tech.Utils.Inteface.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSenderUtil implements EmailSender {
    @Autowired(required = false)
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;//注入模板引擎
    @Value("G12ofSoton@163.com")
    private String from;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            javaMailSender.send(message);
            logger.info("====邮件发送成功====");
        }catch (Exception e){
            logger.info("====发邮件出错=====");
            logger.info(e.toString());
        }
    }

    @Override
    public void sendHtmlEmail(String to, String subject, String content) {
        try {
            Context context =new Context();
            context.setVariable("project","Find a Service");
            context.setVariable("author","G12ofSoton");
            context.setVariable("url","https://github.com/Aaronzhu556/Web_cw1_G12");
            context.setVariable("content",content);
            String emailContent=templateEngine.process("emailTemplate",context);
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(emailContent, true);
            javaMailSender.send(message);
            logger.info("=====HTML邮件发送成功===");
        } catch (MessagingException e) {
           logger.info("=====HTML邮件发送失败====");
           logger.info(e.toString());
        }
    }
    @Override
    public void sendHtmlEmail() {

    }
}
