package com.fergoid.config;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by markferguson on 04/01/2017.
 */
@Configuration
public class MessageConfig {


    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync, ResourceIdResolver resourceIdResolver) {
        return new QueueMessagingTemplate(amazonSQSAsync, resourceIdResolver);
    }


}
