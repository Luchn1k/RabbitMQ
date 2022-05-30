package com.kalana.rabbit.rabbitmqlistner.component;

import com.kalana.rabbit.rabbitmqlistner.config.RabbitMQConfig;
import com.kalana.rabbit.rabbitmqlistner.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void lister(Message message){
        System.out.println(message);
    }
}
