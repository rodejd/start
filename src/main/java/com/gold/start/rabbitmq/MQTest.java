package com.gold.start.rabbitmq;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MQTest {


    public static void main(String[] args) {

        MQProducer producer = new MQProducer();
        MQConsumer consumer = new MQConsumer();

        try {
            // 1. Producer 실행: 메시지 100건 전송
            System.out.println("[Main] Sending 100 messages...");
            producer.sendMessages(100);

            // 2. Consumer 실행: 메시지 소비 (10개의 스레드 사용)
            System.out.println("[Main] Starting consumer with 10 threads...");
            consumer.startConsumer(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
