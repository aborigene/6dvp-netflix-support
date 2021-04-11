package com.dvp6.grupo1.support.broker;

import com.dvp6.grupo1.support.model.SupportEntity;
import com.dvp6.grupo1.support.model.SupportRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupportBrokerConsumer {

    @Autowired
    private SupportRepository supportRepository;

    private SupportEntity supportEntity;

    @RabbitListener(queues = SupportBrokerConfig.QUEUE)
    public void consumer(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
