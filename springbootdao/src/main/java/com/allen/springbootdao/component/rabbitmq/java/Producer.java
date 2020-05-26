//package com.allen.springbootdao.component.rabbitmq.java;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * @Auther: allen
// * @Date: 2020-05-24 13:33
// * @Description:
// */
//public class Producer {
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        //新建一个连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("allen");
//        factory.setPassword("allen");
//
//        //设置rabbitmq地址
//        factory.setHost("172.16.15.105");
//        factory.setPort(5672);
//        factory.setVirtualHost("/");
//
//
//        //建立代理服务器连接
//        Connection connection = factory.newConnection();
//
//        //创建新道
//        Channel channel = connection.createChannel();
//
//        //声明交换器
//        String exchangeName = "hello-exchange";
//        channel.exchangeDeclare(exchangeName, "direct", true);
//
//        String routeKey = "helloRoutekey";
//        //发布消息
//        channel.basicPublish(exchangeName, routeKey, null, "Hello".getBytes());
//
//        channel.close();
//        connection.close();
//    }
//}
