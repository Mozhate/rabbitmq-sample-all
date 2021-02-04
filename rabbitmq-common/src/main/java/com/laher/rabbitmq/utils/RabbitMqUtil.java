package com.laher.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * RabbitMq工具
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/4
 */
public class RabbitMqUtil {
    private final static String HOST = "192.168.50.44";
    private final static Integer PORT = 5672;
    private final static String USER_NAME = "admin";
    private final static String PASS_WORD = "admin";

    /**
     * 获取连接
     *
     * @return rabbitMq连接
     */
    public static ConnectionFactory getConnectionFactory() {
        // rabbitmq连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASS_WORD);
        return factory;
    }

    /**
     * 获取通道
     *
     * @return 结果
     * @throws IOException      IO异常
     * @throws TimeoutException 超时异常
     */
    public static Channel getChannel() throws IOException, TimeoutException {
        // 创建连接对象
        Connection connect = RabbitMqUtil.getConnectionFactory().newConnection();

        // 创建通道
        return connect.createChannel();
    }
}
