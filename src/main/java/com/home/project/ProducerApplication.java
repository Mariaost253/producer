package com.home.project;

import com.home.project.domain.Publisher;
import com.home.project.domain.PublisherEvent;
import com.home.project.dummy.DummyPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;

import java.io.IOException;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ProducerApplication.class, args);
		DummyPublisher dummyPublisher=new DummyPublisher();
		dummyPublisher.addPublisher();
	}

}
