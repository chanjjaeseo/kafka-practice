package com.qcz.kafka.simple;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.CountDownLatch;

public class SimpleMessageProducerPerformance {

    private KafkaProducer producer;

    public SimpleMessageProducerPerformance(KafkaProducer producer) {
        this.producer = producer;
    }

    public void startProduce() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ProducerRecord<String, String> record =
                new ProducerRecord<>("stream-in", "C");
        int count  = 0;
        while (count <= 100) {
            producer.send(record, new DemoProducerCallback());
            count++;
        }
        countDownLatch.await();
    }

    private class DemoProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            System.out.println(recordMetadata.toString());
            System.out.println(e.getMessage());
        }
    }

}
