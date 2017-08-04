package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 第三个消费者, 接受topic的消息他的exchange为exchangeTest2,  pattern为shijj.*..          
 * .*可以匹配一个, .#可以匹配一个或多个..
 * @author Administrator
 */
public class ShijjConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(ShijjConsumer.class);  
      
    @Override  
    public void onMessage(Message message) {  
        logger.info("shijj receive message------->:{}", message);  
    }  
}