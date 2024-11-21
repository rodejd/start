package com.gold.start.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SmsConsumer {

    @RabbitListener(queues = RabbitMQConfig.SMS_QUEUE)
    public void handleSmsMessages(String message) {
        System.out.println(" [SMSConsumer] Received: " + message);
        // 실제 문자 처리 로직 구현
    }
}
