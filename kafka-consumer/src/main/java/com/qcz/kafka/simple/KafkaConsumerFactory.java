package com.qcz.kafka.simple;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

public class KafkaConsumerFactory {

    private static Properties basicProperties() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","127.0.0.1:9092");
        kafkaProps.put("auto.commit", "false");
        kafkaProps.put("group.id", "group1");
        kafkaProps.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        return kafkaProps;
    }

    public static KafkaConsumer newSimpleInstance() {
        return new KafkaConsumer(basicProperties());
    }

}
