package com.jorge.tokenvalidation.controller;

import com.amazonaws.services.sns.model.SubscribeRequest;
import com.jorge.tokenvalidation.service.SnsSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub")
public class SnsSubscribeController {

    private final SnsSubscriptionService service;

    @Autowired
    public SnsSubscribeController(SnsSubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public HttpEntity<String> subscribe (@RequestBody SubscribeRequest request) {
        final String result = service.subscribe(request);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
