package com.dvp6.grupo1.support.broker;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SupportConsumer {

    @RabbitListener(queues = SupportBrokerConfig.QUEUE)
    public void consumer(Message message) {
        // envio para o WebSocket
    }
}