package com.gold.start.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MQConsumer {



    private static final String QUEUE_NAME = "taskQ";

    public void startConsumer(int threadPoolSize) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 병렬 처리를 위한 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 큐 선언
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [Consumer] Waiting for messages. To exit press CTRL+C");

        // QoS 설정
        channel.basicQos(threadPoolSize);

        // 메시지 소비
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            executor.submit(() -> {
                String message = new String(delivery.getBody());
                System.out.println(" [Consumer] Received: '" + message + "'");
                try {
                    // 메시지 처리 시뮬레이션 (1초 지연)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                try {
                    // 메시지 처리 완료 후 확인
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                    System.out.println(" [Consumer] Done and Acknowledged: '" + message + "'");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        };

        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }
}
