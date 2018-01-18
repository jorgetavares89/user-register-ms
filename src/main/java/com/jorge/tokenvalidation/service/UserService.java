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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;
    private UserFactory factory;

    @Autowired
    public UserService(UserRepository repository,
                       UserFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public UserResult create(UserRequest userRequest) {
        final User user = factory.create(userRequest);
        final User created = repository.save(user);
        return factory.createResult(created);
    }

    public List<User> findAll() {
        List<User> methods = Lists.newArrayList(repository.findAll());
        if (methods.isEmpty()) throw new NotFoundException("Users not found");
        return methods;
    }

}
