package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.auth.config.filter.JwtUtils;
import com.gonzalez.desafioquinto.mapper.UserMapper;
import com.gonzalez.desafioquinto.model.entity.UserEntity;
import com.gonzalez.desafioquinto.model.request.AuthenticationRequest;
import com.gonzalez.desafioquinto.model.request.UpdateUserRequest;
import com.gonzalez.desafioquinto.model.response.AuthenticationResponse;
import com.gonzalez.desafioquinto.model.response.ListUserResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import com.gonzalez.desafioquinto.repository.IUserRepository;
import com.gonzalez.desafioquinto.service.abstraction.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class  UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
      private JwtUtils jwtUtils;

    @Autowired
   private    AuthenticationManager authenticationManager;

    private ListUserResponse buildListResponse(List<UserEntity> users) {
        List<UserResponse> userResponses = userMapper.map(users);
        ListUserResponse listUserResponse = new ListUserResponse();
        listUserResponse.setUserResponses(userResponses);
        return listUserResponse;
    }

    @Override
    public UserResponse getById(String id) throws EntityNotFoundException {
        UserEntity user = userRepository.findByUserIdAndSoftDeleteFalse(id);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        return userMapper.map(user);  
    }

    @Override
    public UserResponse getByEmail(String email) throws EntityNotFoundException {
      UserEntity user = userRepository.findByEmail(email);
      if (user == null){
          throw new EntityNotFoundException("User not found");
      }
        return userMapper.map(user);
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
        UserEntity user = userRepository.findByUserIdAndSoftDeleteFalse(updateUserRequest.getUserId());
        user.setName(updateUserRequest.getFirstName());
        user.setEmail(updateUserRequest.getEmail());
        return null;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) throws Exception {
        UserEntity user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            throw new Exception("Invalid email.");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        return new AuthenticationResponse(user.getEmail(), user.getName(), user.getUserId(), jwtUtils.generateToken(user));
    }

/*    @Override
    public UserResponse create(UserRequest request) throws EntityExistsException {
        UserEntity user = userMapper.map(request);
        return userMapper.map(userRepository.save(user));
    }*/

    @Override
    public void delete(String id) throws EntityNotFoundException {
        UserEntity user = findBy(id);
        user.setSoftDelete(true);
        userRepository.save(user);

    }
}
