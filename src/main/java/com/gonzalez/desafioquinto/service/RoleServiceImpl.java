package com.gonzalez.desafioquinto.service;


import com.gonzalez.desafioquinto.config.RoleType;
import com.gonzalez.desafioquinto.model.entity.RoleEntity;
import com.gonzalez.desafioquinto.repository.IRoleRepository;
import com.gonzalez.desafioquinto.service.abstraction.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository iRoleRepository;


    @Override
    public RoleEntity findByName(String name) {
        return iRoleRepository.findByName(RoleType.valueOf(name));
    }
}
