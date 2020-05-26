package com.allen.springbootdao.component.rabbitmq.springboot;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: allen
 * @Date: 2020-05-24 17:24
 * @Description:
 */
@Configuration
public class RabiitMqConfig {


    @Bean
    public DirectExchange myExchange(){
        return new DirectExchange(QueueEnum.QUEUE_MYTEST.getExchangeName(),true,false);
    }

    @Bean
    public Queue myQueue(){
        return new Queue(QueueEnum.QUEUE_MYTEST.getName());
    }

    @Bean
    public Binding mytestBinding(){
        return BindingBuilder
                .bind(myQueue())
                .to(myExchange())
                .with(QueueEnum.QUEUE_MYTEST.getRouteKey());
    }

    //@Bean
    //public MessageListener mytestListener(){
    //    return new MyMessageListener();
    //}
}
