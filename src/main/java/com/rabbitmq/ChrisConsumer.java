package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 第二个消费者, 接受direct的消息(为了测试一个exchange可以发送多个消息), 
 * 他的exchange为exchangeTest,  rout-key为queueTestChris.
 * @author Administrator
 */
public class ChrisConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(ChrisConsumer.class);  
    @Override  
    public void onMessage(Message message) {  
        logger.info("chris receive message------->:{}", message);  
    }  

}