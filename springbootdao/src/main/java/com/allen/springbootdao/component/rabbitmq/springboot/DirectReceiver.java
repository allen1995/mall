package com.allen.springbootdao.component.rabbitmq.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {

    @RabbitListener(queues = "allenqueue")
    public void handlerl(String msg) {
        System.out.println(" MyExchangeReceive : " + msg);


    }
}