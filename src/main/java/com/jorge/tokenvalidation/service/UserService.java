package com.jorge.tokenvalidation.service;

import com.google.common.collect.Lists;
import com.jorge.tokenvalidation.exception.NotFoundException;
import com.jorge.tokenvalidation.model.entity.User;
import com.jorge.tokenvalidation.model.factory.UserFactory;
import com.jorge.tokenvalidation.model.request.UserRequest;
import com.jorge.tokenvalidation.model.result.UserResource;
import com.jorge.tokenvalidation.model.result.UserResult;
import com.jorge.tokenvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;
    private UserFactory factory;
    private SnsNotificationSender<UserResult> notificationSender;
    @Value("${amazon.aws.sns.topic.name.user.created}")
    private String createdTopicName;

    @Autowired
    public UserService(UserRepository repository,
                       UserFactory factory,
                       SnsNotificationSender<UserResult> notificationSender) {
        this.repository = repository;
        this.factory = factory;
        this.notificationSender = notificationSender;
    }

    public UserResult create(UserRequest userRequest) {
        final User user = factory.create(userRequest);
        final User created = repository.save(user);
        final UserResult result = factory.createResult(created);
        notificationSender.send(createdTopicName, result);
        return result;
    }

    public List<User> findAll() {
        List<User> methods = Lists.newArrayList(repository.findAll());
        if (methods.isEmpty()) throw new NotFoundException("Users not found");
        return methods;
    }

}
