package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity,String > {

    StudentEntity findByStudentIdAndSoftDeleteFalse (String id);

    StudentEntity findByName(String name);

    List<StudentEntity> findAll ();
}
