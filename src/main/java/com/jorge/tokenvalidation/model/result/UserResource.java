package com.jorge.tokenvalidation.model.result;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;


public class UserResource extends ResourceSupport {

    public UserResource(Link link) {
        add(link);
    }
}

