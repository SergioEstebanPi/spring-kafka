package com.kafka.msproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (Borra el mensaje), compact (Mantiene el mas actual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // tiempo retencion mensajes, default -1 (no borra)
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // tamaño maximo por segmento 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // tamaño maximo de cada msg, default 1MB

        return TopicBuilder.name("example-topic-1")
                .partitions(1)
                .replicas(1)
                .configs(configurations)
                .build();
    }
}
