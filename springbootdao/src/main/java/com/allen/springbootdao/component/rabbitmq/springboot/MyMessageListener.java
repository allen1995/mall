package com.allen.springbootdao.component.rabbitmq.springboot;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: allen
 * @Date: 2020-05-24 17:41
 * @Description:
 */
//public class MyMessageListener implements MessageListener {
//
//    @Override
//    public void onMessage(Message message) {
//        try {
//            String messageBody = new String(message.getBody(), "UTF-8");
//            System.out.println("收到MyQueue的消息：" + message.getBody());
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//}
