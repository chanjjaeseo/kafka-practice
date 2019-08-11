package com.qcz.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerSample {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    private DefaultCallback defaultCallback;

    public void produceMessage() {
        int count = 0;
        while (count <= 100) {
            kafkaTemplate
                    .send("stream-in", "hello world")
                    .addCallback(defaultCallback);
            count++;
        }
    }

}
