package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.response.ListUserResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;

import javax.persistence.EntityNotFoundException;

public interface IUserService {

    UserResponse getByName (String name) throws EntityNotFoundException;

    ListUserResponse getAll();

    UserResponse update ();

}
