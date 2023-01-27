package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.config.RoleType;
import com.gonzalez.desafioquinto.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,String> {

    RoleEntity findByName(RoleType name);

}
