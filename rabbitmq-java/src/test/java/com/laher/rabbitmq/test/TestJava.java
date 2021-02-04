package com.laher.rabbitmq.test;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 测试类
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/3
 */
public class TestJava {
    private final static String HOST = "192.168.50.44";
    private final static Integer PORT = 5672;
    private final static String USER_NAME = "admin";
    private final static String PASS_WORD = "admin";

    /**
     * exchange：交换机名称
     *
     * 类型：direct、topic、fanout、header
     *
     * direct：队列名完全相同
     *
     * topic：队列名支持通配符
     *
     * fanout：将消息路由到所有绑定的队列中
     *
     * header：路由的规则是根据header来判断，就是arguments参数
     */


    /**
     * 发送消息
     *
     *
     */
    @Test
    public void push() throws IOException, TimeoutException {
        // rabbitmq连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASS_WORD);

        // 创建连接对象
        Connection connect = factory.newConnection();

        // 创建通道
        Channel channel = connect.createChannel();

        // 声明队列，队列不存在直接用会报错（队列名称，是否持久化，是否排他，是否自动删除，队列的参数）
        // 是否持久化：持久化的队列会存盘，在服务器重启的时候可以保证不丢失相关信息
        // 是否排他：排他的队列对首次声明它的连接可见，并在连接断开时自动删除
        // 是否自动删除：自动删除前提，至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时，才会自动删除
        channel.queueDeclare("test", false, false, false, null);

        // 队列不存在直接用会报错，要先声明
        // 发布消息（交换机名称，路由Key，强制性，持久化消息，发送消息）
        // 强制性：没有找到合适的队列，则调用basic.return将消息返回给生产者，若为false，则broker把消息丢弃
        channel.basicPublish("", "test", false, null, "hello rabbit".getBytes("UTF-8"));

        System.out.println("发送消息成功！！");

        // 关闭
        channel.close();
        connect.close();
    }

    @Test
    public void pull() throws IOException, TimeoutException, InterruptedException {
        // rabbitmq连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASS_WORD);

        // 创建连接对象
        Connection connection = factory.newConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明队列
//        channel.queueDeclare("test", false, false, false, null);
        // 创建消费者对象
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(
                    String consumerTag,
                    Envelope envelope,
                    AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                // 获取消息
                System.out.println("接收到:" + new String(body));
            }
        };
        // 监听队列（队列名称，自动回复，消费方法）
        channel.basicConsume("test", true, consumer);
        //等待回调函数执行完毕之后 ， 关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
