package com.jorge.tokenvalidation.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnsSubscriptionService {

    private AmazonSNS amazonSNS;
    private Topic userCreatedTopic;
    @Autowired
    public SnsSubscriptionService(AmazonSNS amazonSNS,
                                  Topic userCreatedTopic) {
        this.amazonSNS = amazonSNS;
        this.userCreatedTopic = userCreatedTopic;
    }

    public SubscribeResult subscribe(SubscribeRequest request) {
        request.setTopicArn(userCreatedTopic.getTopicArn());
        return amazonSNS.subscribe(request);
    }
}
