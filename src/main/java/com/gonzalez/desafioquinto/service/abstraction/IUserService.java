package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.request.AuthenticationRequest;
import com.gonzalez.desafioquinto.model.request.UpdateUserRequest;
import com.gonzalez.desafioquinto.model.request.UserRequest;
import com.gonzalez.desafioquinto.model.response.AuthenticationResponse;
import com.gonzalez.desafioquinto.model.response.ListUserResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public interface IUserService {

    UserResponse getById(String id) throws EntityNotFoundException;

    UserResponse getByEmail (String email) throws EntityNotFoundException;

    ListUserResponse getAll();

    UserResponse update(UpdateUserRequest updateUserRequest) throws Exception;

    //UserResponse create(UserRequest request) throws EntityExistsException;
    AuthenticationResponse login(AuthenticationRequest request)throws Exception;

    void delete(String id) throws EntityNotFoundException;

}
