package com.fergoid.web;

import com.fergoid.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by markferguson on 04/01/2017.
 */
@RestController
@Slf4j
public class SQSController {

    @Autowired
    private MessageService messageService;

     @RequestMapping(path = "/send/{message}", method = RequestMethod.PUT)

    public HttpEntity<?> sendMessage(@PathVariable String message) {
        String s = String.format("I will publish %s", message);
        log.info(s);
        assert (message == null || message.length() == 0);
        messageService.sendMessageOne(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}

