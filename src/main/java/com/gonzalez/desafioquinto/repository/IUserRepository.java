package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,String> {

UserEntity findByNameAndSoftDeleteFalse (String name);

UserEntity findByRole(String role);

}
