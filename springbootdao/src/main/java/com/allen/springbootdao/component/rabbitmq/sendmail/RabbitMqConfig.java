package com.allen.springbootdao.component.rabbitmq.sendmail;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Auther: allen
 * @Date: 2020-05-24 21:57
 * @Description:
 */
@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.allen.springbootdao")
public class RabbitMqConfig {


    @Bean
    public CachingConnectionFactory factory(){
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setUsername ("allen");
        factory.setPassword("allen");
        factory.setHost("172.16.15.105");
        factory.setVirtualHost("/");
        factory.setPort(5672);
        return factory;
    }

    @Bean("jsonRabbitTemplate")
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory factory){

        RabbitTemplate template = new RabbitTemplate(factory);
        //templates.setExchange("mailExchange");
        //templates.setRoutingKey("mail.test");
        template.setMessageConverter(jsonMessageConverter());
        return template;

    }

    @Bean
    public TopicExchange mailExchange(){
        return new TopicExchange("mailExchange", true, false) ;
    }

    @Bean
    public Queue mailQueue(){
        return new Queue("mailQueue");
    }

    @Bean
    public Binding mailBinding(){

        return BindingBuilder
                .bind(mailQueue())
                .to(mailExchange())
                .with("shopping.*");
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
