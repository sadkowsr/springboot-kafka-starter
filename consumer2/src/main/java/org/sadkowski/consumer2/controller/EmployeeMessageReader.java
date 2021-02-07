package org.sadkowski.consumer2.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageReader {

    @KafkaListener(topics = "1")
    public void reader(String name){
        System.out.println("Receive:"+name);
    }
}
