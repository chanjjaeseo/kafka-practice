package com.qcz.kafka.simple;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaProducerFactory {

    private static Properties basicProperties() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers","127.0.0.1:9092");
        // id (全局唯一)
        kafkaProps.put("client.id", "server1");
        // 编解码器
        kafkaProps.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        return kafkaProps;
    }

    public static KafkaProducer newSimpleInstance() {
        return new KafkaProducer(basicProperties());
    }

    public static KafkaProducer newInstance() {
        Properties kafkaProps = basicProperties();
        // ack 级别 同步到所有分区后ack
        kafkaProps.put("acks", "all");
        // 生产者重发消息次数
        kafkaProps.put("retries", 3);
        // 延迟发送时间
        kafkaProps.put("linger.ms", 10000);
        // 缓冲区接收到10条消息后 一次发送到 broker
        kafkaProps.put("batch.size", 10);
        // 该参数指定了生产者在收到服务器晌应之前可以发送多少个消息。
        // 它的值越高，就会占用 越多的内存，不过也会提升吞吐量。
        kafkaProps.put("max.in.flight.requests.per.connection", 10);
        return new KafkaProducer(kafkaProps);
    }

}
