package com.gold.start.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EventProducer {
    private static final String QUEUE_NAME = "eventQueue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            // 큐 선언
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            for (int i = 1; i <= 200; i++) { // 200명의 요청 시뮬레이션
                String message = "User_" + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [Producer] Sent: " + message);
            }
        }
    }
}