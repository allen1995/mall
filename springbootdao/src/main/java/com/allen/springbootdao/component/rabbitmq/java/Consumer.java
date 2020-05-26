//package com.allen.springbootdao.component.rabbitmq.java;
//
//import com.rabbitmq.client.*;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
///**
// * @Auther: allen
// * @Date: 2020-05-24 13:40
// * @Description:
// */
//public class Consumer {
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("allen");
//        factory.setPassword("allen");
//        factory.setHost("172.16.15.105");
//        factory.setPort(5672);
//        factory.setVirtualHost("/");
//
//        //创建代理服务器
//        Connection connection = factory.newConnection();
//
//        //创建信道
//        final Channel channel = connection.createChannel();
//
//        //声明交换器
//        String exchangeName = "hello-exchange";
//        channel.exchangeDeclare(exchangeName, "direct",true);
//
//        //声明队列
//        String queueName = channel.queueDeclare().getQueue();
//        String routeKey = "helloRoutekey";
//
//        //绑定队列
//        channel.queueBind(queueName, exchangeName, routeKey);
//
//        while (true){
//
//            boolean autoAck = false;
//            String consumerTag = "";
//
//            channel.basicConsume(queueName, autoAck,consumerTag, new DefaultConsumer(channel){
//
//                @Override
//                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                    String routingKey = envelope.getRoutingKey();
//                    String contentType = properties.getContentType();
//                    System.out.println("消费得路由键：" + routingKey);
//                    System.out.println("消费的内容类型：" + contentType);
//
//                    long  deliveryTag = envelope.getDeliveryTag();
//                    channel.basicAck(deliveryTag, false);
//
//                    System.out.println("消费内容的消息体：" );
//                    String bodyStr = new String(body, "UTF-8");
//                    System.out.println(bodyStr);
//                }
//            });
//        }
//
//
//    }
//}
