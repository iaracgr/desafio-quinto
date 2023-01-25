package com.gonzalez.desafioquinto.controller;

import com.gonzalez.desafioquinto.model.request.UpdateUserRequest;
import com.gonzalez.desafioquinto.model.request.UserRequest;
import com.gonzalez.desafioquinto.model.response.ListUserResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import com.gonzalez.desafioquinto.service.abstraction.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

   /* @PostMapping("/create")
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) {
        UserResponse userResponse;
        try {
            userResponse = iUserService.create(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }*/

    @PutMapping("/update")
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UpdateUserRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(iUserService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id) throws EntityNotFoundException{
        iUserService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("find/{id}")
    public ResponseEntity<UserResponse> findUser (@PathVariable String id) throws EntityNotFoundException{
        return ResponseEntity.ok(iUserService.getById(id));
    }
    @GetMapping("find/{email}")
    public ResponseEntity<UserResponse> findUserByEmail (@PathVariable String email) throws EntityNotFoundException{
        return ResponseEntity.ok(iUserService.getByEmail(email));
    }
    @GetMapping ("list")
    public ResponseEntity<ListUserResponse> getAll (){
        return ResponseEntity.ok().body(iUserService.getAll());
    }
}
