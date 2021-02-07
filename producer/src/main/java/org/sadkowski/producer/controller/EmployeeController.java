package org.sadkowski.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping
    public ResponseEntity<String> sendToConsumer(@RequestParam String managerId, @RequestParam String id, @RequestParam String name ){
        kafkaTemplate.send(managerId,""+id+", "+name);
        String msg=new String("ManagerId:"+managerId+", id: "+id+" name:"+name+".");
        System.out.println("Sent: "+msg);
        return new ResponseEntity<String>(msg, HttpStatus.ACCEPTED);
    }
}
