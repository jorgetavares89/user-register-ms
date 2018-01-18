package com.jorge.tokenvalidation.model.entity;

import javax.persistence.*;

@Table
@Entity
public class User {
	
    private Long id;
    private String name;
    private String email;
    private String phone;

    public User(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {

        private User user = new User();

        public Builder withId(Long groupId) {
            this.user.setId(groupId);
            return this;
        }

        public Builder withName(String accountId) {
            this.user.setName(accountId);
            return this;
        }

        public Builder withEmail(String email) {
            this.user.setEmail(email);
            return this;
        }

        public Builder withPhone(String phone) {
            this.user.setPhone(phone);
            return this;
        }

        public User build() {
            return this.user;
        }
    }
}
