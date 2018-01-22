package com.jorge.tokenvalidation.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.jorge.tokenvalidation.model.request.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnsNotificationSender {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public SnsNotificationSender(AmazonSNS amazonSns) {
        this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }

    public void send(String topicName, UserCreatedEvent userCreatedEvent) {
        this.notificationMessagingTemplate.convertAndSend(topicName, userCreatedEvent);
    }
}
