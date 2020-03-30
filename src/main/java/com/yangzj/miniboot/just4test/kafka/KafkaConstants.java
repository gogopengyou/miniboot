package com.yangzj.miniboot.just4test.kafka;

/**
 * description:
 *
 * @author: Yangzj
 * @date: 2020/3/30
 */
public class KafkaConstants {
    public static final String BROKER_LIST = "localhost:9092";
    public static final String CLIENT_ID = "client1";
    public static String GROUP_ID_CONFIG="consumerGroup1";

    public static final String TOPIC_NAME = "kafka-test-topic";
    private KafkaConstants() {

    }
}
