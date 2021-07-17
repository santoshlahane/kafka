package com.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.User;

@Service
public class KafkaConsumer {

	//@KafkaListener(topics = "test-san", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed Message : " + message);
	}
	
	@KafkaListener(topics = "test-san", groupId = "group_id", containerFactory = "userConcurrentKafkaListenerContainerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed Json Message: " + user);
	}
}
