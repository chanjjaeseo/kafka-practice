package com.qcz.kafka;

import org.apache.kafka.clients.admin.AdminClient;

import java.util.concurrent.ExecutionException;

public class Console {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AdminClient adminClient = AdminClientFactory.getInstance();
        AdminClientTest adminClientTest = new AdminClientTest(adminClient);
        try {
//            adminClientTest.createTopic();
//            adminClientTest.deleteTopic();
//            adminClientTest.listAllTopics();
            adminClientTest.listConsumerGroups();
        } finally {
            adminClientTest.close();
        }
    }

}
