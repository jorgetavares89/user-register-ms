package com.jorge.tokenvalidation.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev-local")
public class SnsConfigLocal extends AwsGeneralConfigLocal {

    private static final Logger LOG = LoggerFactory.getLogger(SnsConfigLocal.class);

    @Value("${amazon.aws.sns.endpoint}")
    private String amazonSnsEndpoint;
    @Value("${amazon.aws.sns.topic.name.user.created}")
    private String createdTopicName;

    @Bean
    public AmazonSNS amazonSns() {
        LOG.info("Creating the SNS client...");
        return AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(getSNSEndpointConfiguration())
                .withCredentials(getAmazonAWSCredentials())
                .build();
    }

    @Bean
    public Topic userCreatedTopic() {
        return new Topic().withTopicArn(createTopic(createdTopicName).getTopicArn());
    }

    private CreateTopicResult createTopic(String topicName) {
        LOG.debug("Creating the Topic ["+topicName+"]");
        return amazonSns().createTopic(new CreateTopicRequest(topicName));
    }

    private AwsClientBuilder.EndpointConfiguration getSNSEndpointConfiguration() {
        return new AwsClientBuilder.EndpointConfiguration(amazonSnsEndpoint, amazonRegion);
    }

}