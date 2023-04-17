package com.aws.sqs3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.aws.sqs3.config.AmazonSQSConfiguration;
import com.aws.sqs3.model.SQSRequest;
import com.aws.sqs3.service.SQSHandler;

@Service
public class SQSHandlerImpl implements SQSHandler {

    @Value("${cloud.aws.end-point.uri}")
    private String sqsUrl;
    
	@Autowired
	private AmazonSQSConfiguration awsConfig;

	@Override
	public String sendMsgToSQS(SQSRequest sQSRequestBody) {
		// TODO Auto-generated method stub
		SendMessageResult result = awsConfig.amazonSQSClient().sendMessage(sqsUrl, sQSRequestBody.getMessage());
		return "Message sent successfully";
	}

}
