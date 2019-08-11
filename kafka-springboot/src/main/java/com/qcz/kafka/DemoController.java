package com.qcz.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private KafkaProducerSample kafkaProducerSample;

    @RequestMapping("/produce")
    public void produce() {
        kafkaProducerSample.produceMessage();
    }

}
