package com.allen.springbootdao.rabbitmq.springboot;

import com.allen.springbootdao.component.rabbitmq.springboot.QueueEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: allen
 * @Date: 2020-05-24 18:15
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqTests {

    @Autowired
    private RabbitTemplate template;

    @Test
    public void sendMessage(){
        template.convertAndSend(QueueEnum.QUEUE_MYTEST.getName(), "Hello, World!");
    }
}
