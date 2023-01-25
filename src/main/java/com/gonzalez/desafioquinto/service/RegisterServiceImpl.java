package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.auth.RoleType;
import com.gonzalez.desafioquinto.auth.config.filter.JwtUtils;
import com.gonzalez.desafioquinto.mapper.UserMapper;
import com.gonzalez.desafioquinto.model.entity.UserEntity;
import com.gonzalez.desafioquinto.model.request.AuthenticationRequest;
import com.gonzalez.desafioquinto.model.request.UserRequest;
import com.gonzalez.desafioquinto.model.response.AuthenticationResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import com.gonzalez.desafioquinto.repository.IRoleRepository;
import com.gonzalez.desafioquinto.repository.IUserRepository;
import com.gonzalez.desafioquinto.service.abstraction.IRegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class RegisterServiceImpl implements IRegisterUser {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerProfessor(UserRequest request) throws EntityExistsException {
        if (userRepository.findByEmailAndSoftDeleteFalse(request.getEmail()) != null) {
            throw new EntityExistsException();
        }
        UserEntity user = userMapper.map(request,  passwordEncoder.encode(request.getPassword()));
        user.setRoles(List.of(roleRepository.findByName(RoleType.PROFESSOR.getFullRoleName())));
        user.setDescription("PROFESSOR_STANDARD_USER");

        UserResponse response = userMapper.map(userRepository.save(user));

        response.setToken(jwtUtils.generateToken(user));
        return response;

    }
}
