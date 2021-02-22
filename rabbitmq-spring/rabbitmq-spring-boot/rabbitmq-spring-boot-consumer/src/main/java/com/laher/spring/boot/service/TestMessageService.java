package com.laher.spring.boot.service;

/**
 * 测试消息服务
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
public interface TestMessageService {

    /**
     * 默认消息推送
     *
     * @param message 推送信息
     * @author laher
     * @version 1.0.0
     * @date 2021/2/22
     */
    void defaultTestMessage(String message);
}