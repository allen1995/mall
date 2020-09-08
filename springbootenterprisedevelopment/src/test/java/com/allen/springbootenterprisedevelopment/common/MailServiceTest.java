package com.allen.springbootenterprisedevelopment.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.*;

/**
 * @Auther: 20190598
 * @Date: 2020/9/8 10:07
 * @Description:
 */
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSendMail(){
        String from = "872062426@qq.com";
        String to = "1501425721@qq.com";
        String subject = "测试主题";
        String content = "测试内容";

        mailService.sendSimpleMail(from, to, subject, content);
    }

    @Test
    public void testSendAttachMail() throws IOException {
        String from = "872062426@qq.com";
        String to = "1501425721@qq.com";
        String subject = "测试主题";
        String content = "测试内容";
        File file = new File("D:\\test.txt");
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);
        out.write("Hello".getBytes("UTF-8"));
        out.close();

        mailService.sendAttachFileMail(from, to, subject, content, file);
    }

    @Test
    public void testSendMailWithImg() throws IOException {
        String from = "872062426@qq.com";
        String to = "1501425721@qq.com";
        String subject = "测试主题（带图片）";
        String content = "<div>这是一篇带图片的邮件：" +
                "这是图片1：<div><img src='cid:p01' /></div> </div>";
        String[] res = new String[]{"D:\\292883b8-d64e-41a9-a150-d8853dd5f201.jpg"};
        String[] resIds = new String[]{"p01"};

        mailService.sendMailWithImg(from, to, subject, content, res, resIds);
    }

    @Test
    public void testSendHtmlMail(){
        Context context = new Context();
        context.setVariable("username","allen");
        context.setVariable("gendar", "女");
        String content =  templateEngine.process("mailtemplate.html", context);

        mailService.sendHtmlMail(
                "872062426@qq.com",
                "1501425721@qq.com",
                "html测试邮件",
                content
        );
    }

}
