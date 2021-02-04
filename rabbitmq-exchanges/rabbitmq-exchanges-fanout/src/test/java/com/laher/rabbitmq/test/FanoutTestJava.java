package com.laher.rabbitmq.test;

import com.laher.rabbitmq.utils.RabbitMqUtil;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
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
public class FanoutTestJava {
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
        // 创建连接对象
        Connection connect = RabbitMqUtil.getConnectionFactory().newConnection();

        // 创建通道
        Channel channel = connect.createChannel();

        // 声明交换机和fanout类型
        channel.exchangeDeclare("radio_events", BuiltinExchangeType.FANOUT);

        // 声明队列（队列名称，是否持久化，是否排他，是否自动删除，队列的参数）
        // 是否持久化：持久化的队列会存盘，在服务器重启的时候可以保证不丢失相关信息
        // 是否排他：排他的队列对首次声明它的连接可见，并在连接断开时自动删除
        // 是否自动删除：自动删除前提，至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时，才会自动删除
        channel.queueDeclare("fanoutTest", false, false, false, null);

        // 绑定交换机和队列（队列名称，交换机名称，路由key）
        // fanout模式不会检测路由key，只需要简单的将队列绑定到交换机上，直接广播所有生产端
        channel.queueBind("fanoutTest","radio_events","test");

        // 发布消息（交换机名称，路由Key，强制性，持久化消息，发送消息）
        // 强制性：没有找到合适的队列，则调用basic.return将消息返回给生产者，若为false，则broker把消息丢弃
        channel.basicPublish("radio_events", "test", false, null, "hello rabbit fanout".getBytes("UTF-8"));

        System.out.println("发送消息成功！！");

        // 关闭
        channel.close();
        connect.close();
    }

    @Test
    public void pull() throws IOException, TimeoutException, InterruptedException {
        // 创建连接对象
        ConnectionFactory factory = RabbitMqUtil.getConnectionFactory();

        // 创建连接对象
        Connection connection = factory.newConnection();

        // 创建通道
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare("fanoutTest", false, false, false, null);

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
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 监听队列（队列名称，自动回复，消费方法）
        channel.basicConsume("fanoutTest", true, consumer);
        //等待回调函数执行完毕之后 ， 关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
