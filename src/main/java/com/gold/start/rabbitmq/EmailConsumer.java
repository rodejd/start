package com.gold.start.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @RabbitListener(queues = RabbitMQConfig.EMAIL_QUEUE)
    public void handleEmailMessages(String message) {
        System.out.println(" [EmailConsumer] Received: " + message);
        // 실제 이메일 처리 로직 구현
    }
}