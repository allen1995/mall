package com.allen.springbootdao.component.rabbitmq.springboot;

/**
 * @Auther: allen
 * @Date: 2020-05-24 17:21
 * @Description:
 */
public enum  QueueEnum {

    /**
     * 自定义测试枚举
     */
    QUEUE_MYTEST("allenexchange","allenqueue","allenqueue");

    /**
     * 交换器名称
     */
    private String exchangeName;

    /**
     * 队列名
     */
    private String name;

    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchangeName, String name, String routeKey) {
        this.exchangeName = exchangeName;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getName() {
        return name;
    }

    public String getRouteKey() {
        return routeKey;
    }

    @Override
    public String toString() {
        return "QueueEnum{" +
                "exchangeName='" + exchangeName + '\'' +
                ", name='" + name + '\'' +
                ", routeKey='" + routeKey + '\'' +
                '}';
    }

}
