package com.aws.sqs3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.aws.sqs3.config.AmazonSQSConfiguration;
import com.aws.sqs3.model.SQSRequest;
import com.aws.sqs3.service.SQSHandler;

import io.awspring.cloud.messaging.core.QueueMessageChannel;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;

@RestController
@RequestMapping(value = "/aws/sqs")
public class SQSGateway {

	@Autowired
	private SQSHandler handler;
	
	
	@PostMapping(value = "/send-message")
	public String sendMessage(@RequestBody SQSRequest sQSRequestBody) {
		
		return handler.sendMsgToSQS(sQSRequestBody);
	}

    @SqsListener("data-exchange")
    public void loadMessagesFromQueue(String message) {
        System.out.println("Queue Messages: " + message);
    }
    
	
}
