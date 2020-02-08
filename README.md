# Kafka - spring boot - Testing Project

*Producer - url
*Consumer + sprintboot (web server) - url
*Api Testing - url

# Project Highlights
* Kafka 
* spring-boot
* H2 Database integration using JPA
* Unit & Integration tests using junit,rest template, embedded kafka, MockMvc
* Api Tests using Rest-assured, testNG

# Prerequisites
Projects run locally it is prerequisite to have kafka installed on your machine.
https://kafka.apache.org/downloads.html

Start Zookeeper and Kafka Broker
Mac (bin folder)
*Zookeeper
./zookeeper-server-start.sh ../config/zookeeper.properties

*Kafka broker
./kafka-server-start.sh ../config/server.properties

Windows (bin/windows folder)
*Zookeeper
zookeeper-server-start.bat ..\..\config\zookeeper.properties

*Kafka broker
kafka-server-start.bat ..\..\config\server.properties
