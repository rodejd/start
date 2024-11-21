package com.gold.start.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Exchange 이름
    public static final String TOPIC_EXCHANGE = "topic_exchange";

    // Queue 이름
    public static final String EMAIL_QUEUE = "email_queue";
    public static final String SMS_QUEUE = "sms_queue";
    public static final String NOTIFICATION_QUEUE = "notification_queue";

    // 라우팅 키
    public static final String EMAIL_ROUTING_KEY = "email.#";
    public static final String SMS_ROUTING_KEY = "sms.#";
    public static final String NOTIFICATION_ROUTING_KEY = "notification.*";

    // Topic Exchange 생성
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    // Queue 생성
    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE, true); // Durable=true
    }

    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE, true);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(NOTIFICATION_QUEUE, true);
    }

    // Queue와 Exchange 바인딩
    @Bean
    public Binding emailBinding(Queue emailQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(emailQueue).to(topicExchange).with(EMAIL_ROUTING_KEY);
    }

    @Bean
    public Binding smsBinding(Queue smsQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(smsQueue).to(topicExchange).with(SMS_ROUTING_KEY);
    }

    @Bean
    public Binding notificationBinding(Queue notificationQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(notificationQueue).to(topicExchange).with(NOTIFICATION_ROUTING_KEY);
    }
}