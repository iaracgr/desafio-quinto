package com.gonzalez.desafioquinto.controller;

import com.gonzalez.desafioquinto.model.request.UserRequest;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import com.gonzalez.desafioquinto.service.abstraction.IRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IRegisterUser iRegisterUser;

    @PostMapping("/professor")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest request) throws EntityExistsException {
        UserResponse response = iRegisterUser.registerProfessor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
