package com.home.project.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
@Profile("local")
public class AutoCreateConfig { //topic configurations

    @Bean
    public NewTopic publisherEvents(){
        return TopicBuilder.name("publisher-events")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
