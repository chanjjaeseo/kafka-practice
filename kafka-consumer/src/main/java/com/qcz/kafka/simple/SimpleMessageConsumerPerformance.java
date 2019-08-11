package com.qcz.kafka.simple;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Collections;
import java.util.Map;

public class SimpleMessageConsumerPerformance {

    private KafkaConsumer consumer;

    public SimpleMessageConsumerPerformance(KafkaConsumer consumer) {
        this.consumer =  consumer;
    }

    public void startConsume() {
        consumer.subscribe(Collections.singletonList("stream-in"));
        ShutdownHandler.attachShutdownHook(consumer);
        try {
            while (true) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    System.out.println(record.value());
                }
                consumer.commitAsync(new DefaultOffsetCommitCallback());
            }
        } finally {
            consumer.commitSync();
            consumer.close();
        }
    }

    private class DefaultOffsetCommitCallback implements OffsetCommitCallback {

        @Override
        public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
            map.forEach((k, v) -> {
                System.out.println(k);
                System.out.println(v);
            });
        }
    }

}
