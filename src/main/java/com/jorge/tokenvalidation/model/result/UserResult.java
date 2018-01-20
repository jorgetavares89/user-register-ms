package com.jorge.tokenvalidation.model.result;

import com.google.gson.Gson;

import java.util.Objects;

public class UserResult {

    private Long id;
    private String name;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

        public Builder withName(String accountId) {
            this.userResult.setName(accountId);
            return this;
        }

        public Builder withEmail(String email) {
            this.userResult.setEmail(email);
            return this;
        }

        public Builder withPhone(String phone) {
            this.userResult.setPhone(phone);
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
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, phone);
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
