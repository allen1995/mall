package com.allen.springbootdao.component.rabbitmq.sendmail;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Auther: allen
 * @Date: 2020-05-24 22:07
 * @Description:
 */
//@Component
//public class MailListener {
//
//    @RabbitListener( queues = "mailQueue")
//    public void handleMail(Message message) throws IOException {
//        String msg = new String(message.getBody());
//        ObjectMapper objectMapper = new ObjectMapper();
//        Mail mail = objectMapper.readValue(msg, Mail.class);
//        System.out.println(mail.toString());
//    }
//}
