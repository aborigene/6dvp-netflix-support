package com.dvp6.grupo1.support.broker;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupportBrokerConfig {

    public static final String QUEUE = "support-created";
    public static final String EXCHANGE_NAME = "support";
    public static final String ROUTING_KEY = "support-routing";

    @Bean
    public Exchange declareExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Queue declareQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding declareBinding(Exchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }

}
