package com.allen.springbootdao.component.rabbitmq.springboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: allen
 * @Date: 2020-05-24 17:44
 * @Description:
 */
public class SendMessage {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabiitMqConfig.class);
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        template.convertAndSend("Hello, World!");
        ((AnnotationConfigApplicationContext) context).close();
    }
}
