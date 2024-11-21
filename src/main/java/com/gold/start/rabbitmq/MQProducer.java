package com.gold.start.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MQProducer {

    private static final String QUEUE_NAME = "taskQueue";

    public void sendMessages(int count) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 큐 선언
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            // 메시지 전송
            for (int i = 1; i <= count; i++) {
                String message = "Message " + i;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [Producer] Sent: '" + message + "'");
            }
        }
    }


}
