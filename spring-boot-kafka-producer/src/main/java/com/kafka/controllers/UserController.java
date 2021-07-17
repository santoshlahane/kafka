package com.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;

@RestController
@RequestMapping("/kafka")
public class UserController {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	private static final String TOPIC = "test-san";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC, new User(name, "technology", 20000L));
		return "Published Successfully";
	}
}
