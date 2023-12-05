package com.kafka.msproducer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProducerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		return args -> kafkaTemplate.send("example-topic-1", "Hello world from SpringKafka");
	}

}
