package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.model.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,String> {

    UserEntity findByUserIdAndSoftDeleteFalse(String id);

    List<UserEntity> findAll();
}

