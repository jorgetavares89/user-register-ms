package com.jorge.tokenvalidation.model.result;

import com.google.gson.Gson;

import java.util.Objects;

public class UserResult {

    private Long id;
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserResult fromJson(String jsonString) {
        return new Gson().fromJson(jsonString, UserResult.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static class Builder {

        private UserResult userResult = new UserResult();

        public Builder withId(Long id) {
            this.userResult.setId(id);
            return this;
        }

        public Builder withToken(String token) {
            this.userResult.setToken(token);
            return this;
        }

        public UserResult build() {
            return this.userResult;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResult that = (UserResult) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token);
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
