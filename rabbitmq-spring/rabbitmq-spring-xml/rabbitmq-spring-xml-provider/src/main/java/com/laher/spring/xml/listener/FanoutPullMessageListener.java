package com.laher.spring.xml.listener;

import java.nio.charset.StandardCharsets;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 消息监听
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
public class FanoutPullMessageListener implements MessageListener {
    /**
     * 获取消息
     *
     * @param message 消息内容
     */
    @Override
    public void onMessage(Message message) {
        System.out.println("fanoutPullMessage开始消费：" + new String(message.getBody(), StandardCharsets.UTF_8));
        // fanoutPullMessage开始消费：推送消息Fanout！
        // fanoutPullMessage开始消费：推送消息Fanout！

        // 打印两句相同的信息，因为xml中配置两个队列都走该监听器，fanout是广播模式
        // <rabbit:listener ref="fanoutPullMessageListener" queues="messageQueue3,messageQueue4"/>
    }
}
