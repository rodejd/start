import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.util.concurrent.atomic.AtomicInteger;

public class EventConsumer {
    private static final String QUEUE_NAME = "eventQueue";
    private static final int TICKET_LIMIT = 100; // 티켓 제한

    private static AtomicInteger ticketCounter = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 큐 선언
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" [Consumer] Waiting for messages...");

        // QoS 설정 (한 번에 한 메시지만 처리)
        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            int currentCount = ticketCounter.incrementAndGet();

            if (currentCount <= TICKET_LIMIT) {
                System.out.println(" [Consumer] Ticket Assigned to: " + message);
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            } else {
                System.out.println(" [Consumer] Ticket Sold Out for: " + message);
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };

        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {});
    }
}
