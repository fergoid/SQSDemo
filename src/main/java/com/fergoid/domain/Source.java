package com.fergoid.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * Created by markferguson on 09/01/2017.
 */
@Data
public class Source {
    @JsonProperty("Type")
    private String type;
    @JsonProperty("MessageId")
    private String messageId;
    @JsonProperty("TopicArn")
    private String topicArn;
    @JsonProperty("Subject")
    private String subject;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Timestamp")
    private String timeStamp;
    @JsonProperty("SignatureVersion")
    private String signatureVersion;
    @JsonProperty("Signature")
    private String signature;
    @JsonProperty("SigningCertURL")
    private String signingCertURL;
    @JsonProperty("UnsubscribeURL")
    private String unsubscribeURL;

}
