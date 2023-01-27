package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.entity.RoleEntity;

public interface IRoleService {

    RoleEntity findByName (String name);
}
