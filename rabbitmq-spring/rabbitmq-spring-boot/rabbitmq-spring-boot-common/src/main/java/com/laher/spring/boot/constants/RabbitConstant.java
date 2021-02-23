package com.laher.spring.boot.constants;

/**
 * MQ 定义
 * <p>
 *
 * @author laher
 * @version 1.0.0
 * @date 2021/2/22
 */
public class RabbitConstant {
    /**
     * 默认队列
     **/
    public static final String DEFAULT_TEST_QUEUE = "defaultTestQueue";

    /**
     * direct队列
     **/
    public static final String DIRECT_TEST_QUEUE = "directTestQueue";

    /**
     * direct交换机
     **/
    public static final String DIRECT_TEST_EXCHANGE = "directTestExchange";

    // --------------

    /**
     * topic routing队列
     **/
    public static final String TOPIC_TEST_ROUTING_ALL = "topicTestQueue.#";

    /**
     * topic队列
     **/
    public static final String TOPIC_TEST_QUEUE_HELLO = "topicTestQueue.hello";

    /**
     * topic队列
     **/
    public static final String TOPIC_TEST_QUEUE_HELLO2 = "topicTestQueue.hello2";

    /**
     * topic交换机
     **/
    public static final String TOPIC_TEST_EXCHANGE = "topicTestExchange";

    // --------------

}
