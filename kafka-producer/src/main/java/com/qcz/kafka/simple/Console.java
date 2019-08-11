package com.qcz.kafka.simple;

import org.apache.kafka.clients.producer.KafkaProducer;

public class Console {

    public static void main(String[] args) throws InterruptedException {
        KafkaProducer kafkaProducer = KafkaProducerFactory.newSimpleInstance();
//        KafkaProducer kafkaProducer = KafkaProducerFactory.newInstance();
        new SimpleMessageProducerPerformance(kafkaProducer).startProduce();
    }


}
