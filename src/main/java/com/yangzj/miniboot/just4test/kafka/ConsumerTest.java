package com.yangzj.miniboot.just4test.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;
import java.util.Collections;

/**
 * description:
 *
 * @author: Yangzj
 * @date: 2020/3/30
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String, String> consumer = ConsumerCreator.createConsumer();
        // 循环消费消息
        while (true) {
            //subscribe topic and consume message
            consumer.subscribe(Collections.singletonList(KafkaConstants.TOPIC_NAME));

            ConsumerRecords<String, String> consumerRecords =
                    consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("Consumer consume message:" + consumerRecord.value());
            }
        }
    }
}
