//package com.allen.springbootdao.component.rabbitmq.stomp;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
///**
// * @Auther: allen
// * @Date: 2020-05-26 23:27
// * @Description:
// */
//@Component
//public class SendMessage {
//
//    @Autowired
//    @Qualifier("stompRabbitTemplate")
//    private RabbitTemplate rabbitTemplate;
//
//
//    public void send(){
//        String message = "<a href=\"https://www.baidu.com\" target=\"_black\">微醺好时光，美酒三件七折</a>";
//        rabbitTemplate.convertAndSend("stompExchange", "shopping.discount", message.getBytes());
//    }
//}
