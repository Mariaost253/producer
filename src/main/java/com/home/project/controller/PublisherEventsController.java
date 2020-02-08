package com.home.project.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.home.project.domain.PublisherEvent;
import com.home.project.producer.EventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class PublisherEventsController {

    @Autowired
    EventProducer eventProducer;

    @PostMapping("/v1/publisherevent")
    public ResponseEntity<PublisherEvent> postPublisherEvent(@RequestBody PublisherEvent publisherEvent) throws JsonProcessingException {
        eventProducer.sendPublisherEvent(publisherEvent); //integration between controller and actual producer
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherEvent);
    }

    @PutMapping("/v1/publisherevent")
    public ResponseEntity<?> putPublisherEvent(@RequestBody PublisherEvent publisherEvent) throws JsonProcessingException {
        if(publisherEvent.getPublisherID()==null){//changed here
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong or missing publisher id");
        }
        eventProducer.sendPublisherEvent(publisherEvent);
        return ResponseEntity.status(HttpStatus.OK).body(publisherEvent);
    }
}
