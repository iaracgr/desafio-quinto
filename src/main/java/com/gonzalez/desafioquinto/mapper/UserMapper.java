package com.gonzalez.desafioquinto.mapper;

import com.gonzalez.desafioquinto.model.entity.UserEntity;
import com.gonzalez.desafioquinto.model.request.UserRequest;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserResponse map(UserEntity user){
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setFirstName(user.getName());
        userResponse.setEmail(user.getEmail());
     return userResponse;
    }

    public UserEntity map(UserRequest request, String passwordEncrypted){
        UserEntity user = new UserEntity();
        user.setName(request.getFirstName());
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncrypted);
        return user;
    }
    public List<UserResponse> map(List<UserEntity> users) {
        List<UserResponse> responses = new ArrayList<>(users.size());
        for (UserEntity user : users) {
            responses.add(map(user));
        }
        return responses;
    }
}
