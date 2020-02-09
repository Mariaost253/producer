package com.home.project;

import com.home.project.domain.PublisherEvent;
import org.apache.kafka.clients.consumer.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.TestPropertySource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpringJavaAutowiringInspection")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"publisher-events"}, partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
        "spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
public class IntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    EmbeddedKafkaBroker embeddedKafkaBroker;

    private Consumer<Integer, String> consumer;

    @BeforeEach
    void setUp() {
        Map<String, Object> configs = new HashMap<>(KafkaTestUtils.consumerProps("group1", "true", embeddedKafkaBroker));
    }

    @Test
    @Timeout(5)
    void postTestEvent() {

        PublisherEvent event = PublisherEvent.builder()
                .publisherID(2)
                .time("publisher")
                .readings(66)
                .build();

        HttpHeaders headers = new HttpHeaders();


        headers.set("content-type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<PublisherEvent> request = new HttpEntity<>(event, headers);


        ResponseEntity<PublisherEvent> responseEntity =restTemplate.exchange("/v1/publisherevent", HttpMethod.POST, request, PublisherEvent.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

    }

    @Test
    @Timeout(5)
    void putTestEvent()  {
        PublisherEvent event = PublisherEvent.builder()
                .publisherID(2)
                .time("333")
                .readings(67)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", MediaType.APPLICATION_JSON.toString());
        HttpEntity<PublisherEvent> request = new HttpEntity<>(event, headers);

        ResponseEntity<PublisherEvent> responseEntity =restTemplate.exchange("/v1/publisherevent", HttpMethod.PUT, request, PublisherEvent.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


    }


    }







