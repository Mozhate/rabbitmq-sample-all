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
public class TopicPullMessageListener implements MessageListener {
    /**
     * 获取消息
     *
     * @param message 消息内容
     */
    @Override
    public void onMessage(Message message) {
        System.out.println("topicPullMessage开始消费：" + new String(message.getBody(), StandardCharsets.UTF_8));
        // topicPullMessage开始消费：推送消息Topic！
    }
}
