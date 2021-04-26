package com.aish.bookstoreconsumer.listener;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aish.bookstoreconsumer.model.Users;

@Service
public class KafkaConsumerListener {

	/**
	 * To consume User type JSON data 
	 * @param user
	 */
	@KafkaListener(topics="book-store-data", groupId ="book-store-consumer")
	public void consumeJson(List<Users> user) {
		System.out.println("consumed json message :"+user);
	}
	
}
