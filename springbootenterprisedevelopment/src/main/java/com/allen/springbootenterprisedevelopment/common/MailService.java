package com.allen.springbootenterprisedevelopment.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Auther: 20190598
 * @Date: 2020/9/8 09:26
 * @Description:
 */
@Component
public class MailService {

    @Autowired
    private JavaMailSender sender;

    /**
     * 简单邮件发送
     * @param from
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String from, String to,
                               String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        sender.send(message);
    }

    /**
     * 发送带有附件的邮件
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param file
     */
    public void sendAttachFileMail(String from, String to, String subject, String content, File file ){
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = getMailMainbody(message, from, to, subject, content, true);
            helper.addAttachment(file.getName(), file);

            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    public void sendMailWithImg(String from, String to, String subject, String content,
                                String srcPath[], String resIds[]){
        if( srcPath.length != resIds.length ){
            System.out.println("图片资源数量不匹配，发送失败！");
            return;
        }

        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = getMailMainbody(message, from, to, subject, content, true);

            for ( int i = 0; i < srcPath.length; i++){
                FileSystemResource resource = new FileSystemResource(new File(srcPath[i]));
                helper.addInline(resIds[i], resource);
            }

            sender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendHtmlMail(String from, String to, String subject, String content){
        try {
            MimeMessage message  = sender.createMimeMessage();
            MimeMessageHelper helper = getMailMainbody(message, from, to ,subject,
                    content, true);

            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessageHelper getMailMainbody(MimeMessage message,String from, String to,
                                                 String subject, String content, boolean isHtml) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, isHtml);

        return helper;
    }
}
