package com.aws.sqs3.service;

import com.aws.sqs3.model.SQSRequest;

public interface SQSHandler {

	public String sendMsgToSQS(SQSRequest sQSRequestBody);
}
