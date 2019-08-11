package com.qcz.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerSample {


    private final Logger logger = LoggerFactory.getLogger(Application.class);

    @KafkaListener(
            id = "consumer1",
            groupId = "group1",
            topics = "stream-in",
            concurrency = "10",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumer1(@Payload String msg,
//                          @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
                          @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                          @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts
    ) {
        logger.info("has received message: " + msg
//                + " ,key:" + key
                + " ,partition:" + partition
                + " ,topic:" + topic
                + " ,ts:" + ts);
    }

}
