package com.gold.start.rabbitmq;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mq")
@RequiredArgsConstructor
public class MQController {

    private final RabbitMQProducer producer;

    // 메시지 전송 API
    @PostMapping("/send")
    public String sendMessage(@RequestParam String routingKey, @RequestParam String message) {
        producer.sendMessage(routingKey, message);
        return "Message sent to RabbitMQ: " + routingKey + " -> " + message;
    }

    /*
    *
    * curl -X POST "http://localhost:8080/api/rabbitmq/send" -d "routingKey=email.info" -d "message=Welcome Email Sent"
    * curl -X POST "http://localhost:8080/api/rabbitmq/send" -d "routingKey=sms.alert" -d "message=SMS Alert Sent"
    * curl -X POST "http://localhost:8080/api/rabbitmq/send" -d "routingKey=notification.general" -d "message=General Notification Sent"
    *
    * */

}
