package com.gold.start.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void handleNotificationMessages(String message) {
        System.out.println(" [NotificationConsumer] Received: " + message);
        // 실제 알림 처리 로직 구현
    }
}