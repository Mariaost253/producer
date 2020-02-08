## Kafka - spring boot - Testing Project

* Producer - https://github.com/Mariaost253/producer
* Consumer + sprintboot (web server) - https://github.com/Mariaost253/webserver-consumer
* Api Testing - https://github.com/Mariaost253/api-testing

## Project Highlights
* Kafka 
* spring-boot
* H2 Database integration using JPA
* Unit & Integration tests using junit,rest template, embedded kafka, MockMvc, Mockito
* Api Tests using Rest-assured, testNG

## Content (tests)
[Producer controller - Inegration test](https://github.com/Mariaost253/producer/blob/master/src/test/java/com/home/project/IntegrationTest.java)
[Api tests](https://github.com/Mariaost253/api-testing/blob/master/src/test/java/testcases/ApiTests.java)
[Controller unit test](https://github.com/Mariaost253/webserver-consumer/blob/master/src/test/java/com/consumer/projectconsumer/wenServerTests/unit/ControllerUnitTest.java)
[Service unit test](https://github.com/Mariaost253/webserver-consumer/blob/master/src/test/java/com/consumer/projectconsumer/wenServerTests/unit/ServiceUnitTest.java)

## Prerequisites
Projects run locally it is prerequisite to have kafka installed on your machine.
https://kafka.apache.org/downloads.html

Start Zookeeper and Kafka Broker
Mac (bin folder)
* Zookeeper - 
./zookeeper-server-start.sh ../config/zookeeper.properties

* Kafka broker -
./kafka-server-start.sh ../config/server.properties

Windows (bin/windows folder)
* Zookeeper-
zookeeper-server-start.bat ../../config/zookeeper.properties

* Kafka broker -
kafka-server-start.bat ../../config/zookeeper.properties

## Steps to run project
* Make sure the zookeeper and kafka cluster are running 
* Run the producer - http://localhost:8080/ - will triger a dummy publisher
* Run the consumer (webserver) - http://localhost:8081/ - will run both consumer and web server
* Run the rest assured tests 
