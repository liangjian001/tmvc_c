package com.rabbitmq;  
  
import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;  
  
/**
 * 发消息的类
 * @author Administrator
 */
@Service
public class MessageSender {  
      
    private AmqpTemplate amqpTemplate;
      
    private String routingKey;
    
    //@Resource(name="rabbitTemplate")
    //private RabbitTemplate rabbitTemplate;
  
    public AmqpTemplate getAmqpTemplate() {  
        return amqpTemplate;  
    }  
  
    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {  
        this.amqpTemplate = amqpTemplate;  
    }  
  
    public String getRoutingKey() {  
        return routingKey;  
    }  
  
    public void setRoutingKey(String routingKey) {  
        this.routingKey = routingKey;  
    }  
  
    public void sendDataToQueue(Object obj) {  
        amqpTemplate.convertAndSend(this.routingKey, obj);  
    }
    
    /*
    public void sendMessageToQueue(Object obj){
    	rabbitTemplate.convertAndSend(this.routingKey, obj);
    }*/
      
}  