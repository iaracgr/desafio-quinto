package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository {

    StudentEntity findByStudentIdAndSoftDeleteFalse (String id);

    StudentEntity findByStudentNameAndSoftDeleteFalse(String name);

    List<StudentEntity> findAll ();
}
