package com.laher.spring.xml.service;

/**
 * 消息服务
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/5
 */
public interface MessageService {
    /**
     * 推送消息
     *
     * @param message 推送内容
     * @author laher
     * @date 2021/2/5
     */
    void pushMessage(String message);

    /**
     * 推送topic消息
     *
     * @param message 推送内容
     * @author laher
     * @date 2021/2/5
     */
    void pushTopicMessage(String message);

    /**
     * 推送fanout消息
     *
     * @param message 推送内容
     * @author laher
     * @date 2021/2/5
     */
    void pushFanoutMessage(String message);
}
