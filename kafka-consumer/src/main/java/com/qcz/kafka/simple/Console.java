package com.qcz.kafka.simple;


import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Console {

    public static void main(String[] args) {
        KafkaConsumer kafkaConsumer = KafkaConsumerFactory.newSimpleInstance();
        new SimpleMessageConsumerPerformance(kafkaConsumer).startConsume();
    }

}
