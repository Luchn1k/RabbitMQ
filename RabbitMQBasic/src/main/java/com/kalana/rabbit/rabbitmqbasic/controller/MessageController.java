package com.kalana.rabbit.rabbitmqbasic.controller;

import com.kalana.rabbit.rabbitmqbasic.config.RabbitMQConfig;
import com.kalana.rabbit.rabbitmqbasic.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Message message){
        message.setId(UUID.randomUUID().toString());
        message.setTime(new Date());
        template.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE,RabbitMQConfig.ROUTING_KEY,message);
        return "Message published";
    }
}
