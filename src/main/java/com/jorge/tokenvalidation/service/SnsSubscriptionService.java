package com.jorge.tokenvalidation.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.Topic;
import com.jorge.tokenvalidation.model.result.SubscribeResult;
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

    public String subscribe(SubscribeRequest request) {
        request.setTopicArn(userCreatedTopic.getTopicArn());
        final String subscriptionArn = amazonSNS.subscribe(request).getSubscriptionArn();
        return new SubscribeResult(subscriptionArn).toJson();
    }
}
