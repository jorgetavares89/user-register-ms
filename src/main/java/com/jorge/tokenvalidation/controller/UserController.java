package com.jorge.tokenvalidation.controller;

import com.jorge.tokenvalidation.model.request.UserRequest;
import com.jorge.tokenvalidation.model.result.UserResource;
import com.jorge.tokenvalidation.model.result.UserResult;
import com.jorge.tokenvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public HttpEntity<UserResource> create(@RequestBody UserRequest userRequest) {
        final UserResult result = service.create(userRequest);
        final Link link = linkTo(UserController.class).slash(result.getId()).withSelfRel();
        final UserResource resource = new UserResource(link);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resource);
    }
}
