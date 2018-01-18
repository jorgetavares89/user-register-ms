package com.jorge.tokenvalidation.model.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class UserRequest {

    private String name;
    private String email;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRequest fromJson(String jsonString) throws IOException {
        return new ObjectMapper().readValue(jsonString, UserRequest.class);
    }

    public String toJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

    public static class Builder {

        private UserRequest userRequest = new UserRequest();

        public Builder withName(String accountId) {
            this.userRequest.setName(accountId);
            return this;
        }

        public Builder withEmail(String email) {
            this.userRequest.setEmail(email);
            return this;
        }

        public Builder withPhone(String phone) {
            this.userRequest.setPhone(phone);
            return this;
        }

        public UserRequest build() {
            return this.userRequest;
        }
    }


}
