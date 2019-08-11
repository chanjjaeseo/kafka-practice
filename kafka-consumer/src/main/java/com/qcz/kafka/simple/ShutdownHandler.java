package com.qcz.kafka.simple;


import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ShutdownHandler {

    public static void attachShutdownHook(KafkaConsumer consumer) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            consumer.wakeup();
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

}
