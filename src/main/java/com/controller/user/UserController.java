package com.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.CommonMessage;
import com.rabbitmq.MessageSender;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Resource  
    private MessageSender messageSender;
    
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/getUserList")
	public String getUserList(){
		 CommonMessage message = new CommonMessage();  
	     message.setSource("tonson");  
	     JSONObject obj = new JSONObject();  
	     obj.put("test", "test json message");  
	     message.setMessage(obj);  
	     messageSender.setRoutingKey("message.tonson");  
	     messageSender.sendDataToQueue(message);
		return "user/user";
	}
}
