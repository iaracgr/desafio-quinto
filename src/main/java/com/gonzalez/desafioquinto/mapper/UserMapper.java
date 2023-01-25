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
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setDescription(user.getDescription());
        userResponse.setRole(user.getRoles().get(0).getName());
        return userResponse;
    }

    public UserEntity map(UserRequest request, String passwordEncrypted) {
        UserEntity userRegister = new UserEntity();
        userRegister.setName(request.getName());
        userRegister.setEmail(request.getEmail());
        userRegister.setPassword(passwordEncrypted);
        return userRegister;
    }
    public List<UserResponse> map(List<UserEntity> users) {
        List<UserResponse> responses = new ArrayList<>(users.size());
        for (UserEntity user : users) {
            responses.add(map(user));
        }
        return responses;
    }
}
