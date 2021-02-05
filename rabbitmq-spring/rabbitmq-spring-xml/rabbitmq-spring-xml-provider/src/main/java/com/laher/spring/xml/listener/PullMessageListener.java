package com.laher.spring.xml.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.nio.charset.StandardCharsets;

/**
 * 消息监听
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
public class PullMessageListener implements MessageListener {
    /**
     * 获取消息
     *
     * @param message 消息内容
     */
    @Override
    public void onMessage(Message message) {
        System.out.println("开始消费：" + new String(message.getBody(), StandardCharsets.UTF_8));
        // 开始消费：推送消息ABCD！
    }
}
