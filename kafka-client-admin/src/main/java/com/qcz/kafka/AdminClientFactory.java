package com.qcz.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Properties;

public class AdminClientFactory {

    public static AdminClient getInstance() {
        Properties props = new Properties();
        String brokerList = "localhost:9092";
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
        return AdminClient.create(props);
    }

}
