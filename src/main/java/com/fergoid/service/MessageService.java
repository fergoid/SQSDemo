package com.fergoid.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fergoid.domain.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by markferguson on 04/01/2017.
 */
@Service
@Slf4j
public class MessageService {

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Value("mf-appqueue-one")
    private String queue;

    public void sendMessageOne(String msg) {
        String uuid = UUID.randomUUID().toString();
        String message = String.format("message: %s-%s @ time: %s", msg, uuid, LocalDateTime.now().toString());
        log.info("Sending message " + message + " to " + queue);
        queueMessagingTemplate.convertAndSend(queue, MessageBuilder.withPayload(message).build());
        log.info("Message sent");
    }

    @SqsListener({"mf-appqueue-two"})
    public void receiveMessageTwo(String msg) throws IOException {
        log.info("Q234: Received Message Payload: " + msg);
        ObjectMapper mapper = new ObjectMapper();

        Source source = mapper.readValue(msg, Source.class);
        log.info((source.toString()));

    }


}
