package com.fergoid;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fergoid.domain.Source;
import lombok.extern.java.Log;
import org.junit.Test;

/**
 * Created by markferguson on 10/01/2017.
 */
@Log
public class SourceTest {

    @Test
    public void testJson() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        String msg = "{\"Type\":\"Notification\",\"MessageId\":\"98514b67-3d8e-5c0b-9743-1b8afb43e062\",\"TopicArn\":\"arn:aws:sns:eu-west-1:659378156385:mf-topicthree\",\"Subject\":\"ALARM: \\\"mf-alarm-three\\\" in EU - Ireland\",\"Message\":\"{\\\"AlarmName\\\":\\\"mf-alarm-three\\\",\\\"AlarmDescription\\\":\\\"This metric monitors queue depth\\\",\\\"AWSAccountId\\\":\\\"659378156385\\\",\\\"NewStateValue\\\":\\\"ALARM\\\",\\\"NewStateReason\\\":\\\"Threshold Crossed: 2 datapoints were greater than or equal to the threshold (7.0). The most recent datapoints: [7.0, 7.0].\\\",\\\"StateChangeTime\\\":\\\"2017-01-09T17:12:45.390+0000\\\",\\\"Region\\\":\\\"EU - Ireland\\\",\\\"OldStateValue\\\":\\\"OK\\\",\\\"Trigger\\\":{\\\"MetricName\\\":\\\"ApproximateNumberOfMessagesVisible\\\",\\\"Namespace\\\":\\\"AWS/SQS\\\",\\\"Statistic\\\":\\\"AVERAGE\\\",\\\"Unit\\\":null,\\\"Dimensions\\\":[{\\\"name\\\":\\\"QueueName\\\",\\\"value\\\":\\\"mf-appqueue-one\\\"}],\\\"Period\\\":60,\\\"EvaluationPeriods\\\":6,\\\"ComparisonOperator\\\":\\\"GreaterThanOrEqualToThreshold\\\",\\\"Threshold\\\":7.0}}\",\"TimeStamp\":\"2017-01-09T17:12:45.467Z\",\"SignatureVersion\":\"1\",\"Signature\":\"EAK0FpRwlSWLX+G10oclP0ATvkfGEecc9jcKhluhgXx7hlgBfuryM5bWdD1E82spCA9081wuYMFOps7X+Uo17aA9T12jSU/S7wOGrr+8KdLxy6hJcWNmHnBl/gACAdNVKrIcjC4mO3mC18mdSMjte2bFFfGz7sGVtyC2H/NheKaROTcD6Yau7XH+6JP215UM27jhb4Bgx7CB7XHCnPic6ACFS/mtsFMp4zK2dofL4IXip43fLpn+02MKems9h9JD6dnyY+1uLCEmTRFV9qGdM158hd77ON20WBxWq0iDw4EmKtOP3YAqZiuuEeMlWJ2tOic2yzJxUmmu2t1zuwnq2g==\",\"SigningCertURL\":\"https://sns.eu-west-1.amazonaws.com/SimpleNotificationService-b95095beb82e8f6a046b3aafc7f4149a.pem\",\"UnsubscribeURL\":\"https://sns.eu-west-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:eu-west-1:659378156385:mf-topicthree:0c6171b3-5b5b-43cf-84be-98a9804d3bae\"}";
        log.info(msg);
        Source source = mapper.readValue(msg, Source.class);
        log.info(source.toString());

        Source src = new Source();
        src.setType("Notification");
        src.setMessageId("98514b67-3d8e-5c0b-9743-1b8afb43e062");
        src.setTopicArn("arn:aws:sns:eu-west-1:659378156385:mf-topicthree");
        src.setSubject("ALARM: \"mf-alarm-three\" in EU - Ireland");
        src.setMessage("{\"AlarmName\":\"mf-alarm-three\",\"AlarmDescription\":\"This metric monitors queue depth\",\"AWSAccountId\":\"659378156385\",\"NewStateValue\":\"ALARM\",\"NewStateReason\":\"Threshold Crossed: 2 datapoints were greater than or equal to the threshold (7.0). The most recent datapoints: [7.0, 7.0].\",\"StateChangeTime\":\"2017-01-09T17:12:45.390+0000\",\"Region\":\"EU - Ireland\",\"OldStateValue\":\"OK\",\"Trigger\":{\"MetricName\":\"ApproximateNumberOfMessagesVisible\",\"Namespace\":\"AWS/SQS\",\"Statistic\":\"AVERAGE\",\"Unit\":null,\"Dimensions\":[{\"name\":\"QueueName\",\"value\":\"mf-appqueue-one\"}],\"Period\":60,\"EvaluationPeriods\":6,\"ComparisonOperator\":\"GreaterThanOrEqualToThreshold\",\"Threshold\":7.0}}");
        src.setTimeStamp("2017-01-09T17:12:45.467Z");
        src.setSignatureVersion("1");
        src.setSignature("EAK0FpRwlSWLX+G10oclP0ATvkfGEecc9jcKhluhgXx7hlgBfuryM5bWdD1E82spCA9081wuYMFOps7X+Uo17aA9T12jSU/S7wOGrr+8KdLxy6hJcWNmHnBl/gACAdNVKrIcjC4mO3mC18mdSMjte2bFFfGz7sGVtyC2H/NheKaROTcD6Yau7XH+6JP215UM27jhb4Bgx7CB7XHCnPic6ACFS/mtsFMp4zK2dofL4IXip43fLpn+02MKems9h9JD6dnyY+1uLCEmTRFV9qGdM158hd77ON20WBxWq0iDw4EmKtOP3YAqZiuuEeMlWJ2tOic2yzJxUmmu2t1zuwnq2g==");
        src.setSigningCertURL("https://sns.eu-west-1.amazonaws.com/SimpleNotificationService-b95095beb82e8f6a046b3aafc7f4149a.pem");
        src.setUnsubscribeURL("https://sns.eu-west-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:eu-west-1:659378156385:mf-topicthree:0c6171b3-5b5b-43cf-84be-98a9804d3bae");

        String src1 = mapper.writeValueAsString(src);
        log.info(src1);

    }
}
