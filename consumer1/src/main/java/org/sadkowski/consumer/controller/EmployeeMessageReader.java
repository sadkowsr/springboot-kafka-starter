package org.sadkowski.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageReader {

    @KafkaListener(topics = "2")
    public void reader(String name){
        System.out.println("Receive:"+name);
    }

}
