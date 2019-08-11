package com.qcz.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class AdminClientTest {

    private AdminClient adminClient;

    public AdminClientTest(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    public void listAllTopics() throws ExecutionException, InterruptedException {
        adminClient.listTopics().names().get().forEach(
                name -> {
                    System.out.println(name);
                }
        );
    }

    public void createTopic() {
        NewTopic topic = new NewTopic("test-topic", 3, (short) 1);
        CreateTopicsResult result = adminClient.createTopics(Collections.singletonList(topic));
        result.values().forEach(
                (k,v) -> {
                    System.out.println(k);
                    try {
                        System.out.println(v.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    System.out.println("====================");
                }
        );
    }

    public void deleteTopic() {
        System.out.println(
                adminClient.deleteTopics(Collections.singletonList("test-topic")));
    }

    public void listConsumerGroups() throws ExecutionException, InterruptedException {
        adminClient.listConsumerGroups().all().get().forEach(
                v -> {
                    System.out.println(v.toString());
                }
        );
        System.out.println("==========================");
        adminClient.listConsumerGroupOffsets("demo")
                .partitionsToOffsetAndMetadata()
                .get().forEach(
                    (k,v)-> {
                        System.out.println(k.toString());
                        System.out.println(v.toString());
                        System.out.println("=====================");
                    }
        );
    }


    public void close() {
        adminClient.close();
    }

}
