package com.customerApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.customerApp.constant.AppConstants;
import com.customerApp.entity.Order;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String , Order> kafkaTemplate;
	
	public String addMsg(Order order) {
		kafkaTemplate.send(AppConstants.TOPIC, order.getId(), order);
		return "Message Published To Kafka Topic";
	}


}


