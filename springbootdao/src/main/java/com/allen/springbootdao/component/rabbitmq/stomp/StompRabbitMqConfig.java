//package com.allen.springbootdao.component.rabbitmq.stomp;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Auther: allen
// * @Date: 2020-05-24 21:57
// * @Description:
// */
//@Configuration
//public class StompRabbitMqConfig {
//
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//
//    @Value("${spring.rabbitmq.host}")
//    private String host;
//
//    @Value("${spring.rabbitmq.port}")
//    private int port;
//
//    @Bean
//    public CachingConnectionFactory factory(){
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        factory.setUsername (username);
//        factory.setPassword(password);
//        factory.setHost(host);
//        factory.setVirtualHost("/");
//        factory.setPort(port);
//        return factory;
//    }
//
//    @Bean("stompRabbitTemplate")
//    public RabbitTemplate rabbitTemplate(CachingConnectionFactory factory){
//
//        RabbitTemplate templates = new RabbitTemplate(factory);
//        templates.setMessageConverter(jsonMessageConverter());
//        return templates;
//
//    }
//
//    @Bean
//    public TopicExchange stompExchange(){
//        return new TopicExchange("stompExchange", true, false) ;
//    }
//
//    @Bean
//    public Queue stompQueue(){
//        return new Queue("stompQueue");
//    }
//
//    @Bean
//    public Binding mailBinding(){
//
//        return BindingBuilder
//                .bind(stompQueue())
//                .to(stompExchange())
//                .with("shopping.*");
//    }
//
//    @Bean
//    public Jackson2JsonMessageConverter jsonMessageConverter(){
//        return new Jackson2JsonMessageConverter();
//    }
//
//}
