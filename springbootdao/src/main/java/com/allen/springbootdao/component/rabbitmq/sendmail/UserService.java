package com.allen.springbootdao.component.rabbitmq.sendmail;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Auther: allen
 * @Date: 2020-05-24 21:52
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    @Qualifier(value = "jsonRabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    /**
     * 用户注册方法
     */
    public void userRegistry(){
        // 用户持久化

        // 注册成功给用户发送
        Mail mail = new Mail();
        mail.setFrom("xx公司");
        mail.setTo("8720xx324@qq.com");
        mail.setSubject("邮件标题");
        mail.setContent("注册成功");
        rabbitTemplate.convertAndSend("mailExchange" ,"mail.test", mail);
    }
}
