package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.mapper.UserMapper;
import com.gonzalez.desafioquinto.model.entity.UserEntity;
import com.gonzalez.desafioquinto.model.request.UpdateUserRequest;
import com.gonzalez.desafioquinto.model.request.UserRequest;
import com.gonzalez.desafioquinto.model.response.ListUserResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import com.gonzalez.desafioquinto.repository.IUserRepository;
import com.gonzalez.desafioquinto.service.abstraction.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserResponse getByName(String name) throws EntityNotFoundException {
        UserEntity user = userRepository.findByNameAndSoftDeleteFalse(name);
        if (user == null) {
            throw new EntityNotFoundException("User not found.");
        }
        return userMapper.map(user);
    }

    private ListUserResponse buildListResponse(List<UserEntity> users) {
        List<UserResponse> userResponses = userMapper.map(users);
        ListUserResponse listUserResponse = new ListUserResponse();
        listUserResponse.setUserResponses(userResponses);
        return listUserResponse;
    }

    @Override
    public ListUserResponse getAll() {
        List<UserEntity> users = userRepository.findAll();
        return buildListResponse(users);
    }

    private UserEntity findBy (String id){
        Optional<UserEntity> opt = Optional.ofNullable(userRepository.findByUserIdAndSoftDeleteFalse(id));
    if (opt.isEmpty()){
        throw new EntityNotFoundException("User not found.");
    }
    return opt.get();
    }

    @Override
    public UserResponse update(UpdateUserRequest updateUserRequest) throws Exception {
        UserEntity user = userRepository.findByNameAndSoftDeleteFalse(updateUserRequest.getFirstName());
        user.setName(updateUserRequest.getFirstName());
        user.setEmail(updateUserRequest.getEmail());
        //  user.setPassword(bCryptPasswordEncoder.encode(updateUserRequest.getPassword()));
        user.setRole(updateUserRequest.getRole());
        return null;
    }

    @Override
    public UserResponse create(UserRequest request) throws EntityExistsException {
        UserEntity user = userMapper.map(request, request.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        return userMapper.map(userRepository.save(user));
    }

    @Override
    public void delete(String id) throws EntityNotFoundException {
        UserEntity user = findBy(id);
        user.setSoftDelete(true);
        userRepository.save(user);

    }
}
