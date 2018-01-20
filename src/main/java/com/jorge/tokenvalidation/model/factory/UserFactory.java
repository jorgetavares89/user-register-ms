package com.jorge.tokenvalidation.model.factory;

import com.jorge.tokenvalidation.model.entity.User;
import com.jorge.tokenvalidation.model.request.UserRequest;
import com.jorge.tokenvalidation.model.result.UserResource;
import com.jorge.tokenvalidation.model.result.UserResult;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public UserRequest createRequest(User user) {
        return new UserRequest.Builder()
                .withName(user.getName())
                .withEmail(user.getEmail())
                .withPhone(user.getPhone())
                .build();
    }

    public UserResult createResult(User user, String token) {
        return new UserResult.Builder()
                .withId(user.getId())
                .withToken(token)
                .build();
    }

	public User create(UserRequest userRequest) {
		return new User.Builder()
                .withName(userRequest.getName())
                .withEmail(userRequest.getEmail())
                .withPhone(userRequest.getPhone())
                .build();
    }

}
