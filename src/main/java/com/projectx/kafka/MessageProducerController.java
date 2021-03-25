package com.projectx.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageProducerController {
    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    /*@GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") final String message){
        kafkaTemplate.send(TOPIC, message);
        return "Message Published!";
    }*/

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book){
        kafkaTemplate.send(TOPIC, book);
        return "Message Published!";
    }
}
