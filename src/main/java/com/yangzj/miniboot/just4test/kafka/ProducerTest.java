package com.yangzj.miniboot.just4test.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

/**
 * description:
 *
 * @author: Yangzj
 * @date: 2020/3/30
 */
public class ProducerTest {

    public static void main(String[] args) {
        Producer<String, String> producer = ProducerCreator.createProducer();

        ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConstants.TOPIC_NAME, "hello, Kafka! 123");
        try {
            //send message
            RecordMetadata metadata = producer.send(record).get();
            System.out.println("Record sent to partition " + metadata.partition()
                    + " with offset " + metadata.offset());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Error in sending record");
            e.printStackTrace();
        }
        producer.close();
    }
}
