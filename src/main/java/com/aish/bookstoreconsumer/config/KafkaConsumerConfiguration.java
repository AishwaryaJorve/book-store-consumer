package com.aish.bookstoreconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.aish.bookstoreconsumer.model.Users;


@Configuration
@EnableKafka
public class KafkaConsumerConfiguration {

	/**
	 * Set consumer factory for User 
	 * @return DefaultKafkaConsumerFactory
	 */
	@Bean
	public ConsumerFactory<String, Users> userConsumerFactory() {

		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "book-store-consumer"); 
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, Users>(config, new StringDeserializer(),
				new JsonDeserializer<>(Users.class));

	}
	
	/**
	 * Inject consumer factory on kafka listener factory
	 * @return
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Users> userkafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Users> factory= new ConcurrentKafkaListenerContainerFactory<String, Users>();
		
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	}
	
}
