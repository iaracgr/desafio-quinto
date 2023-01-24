package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfessorRepository {

    ProfessorEntity findByProfessorIdAndSoftDeleteFalse (String id);

    ProfessorEntity findByProfessorName (String name);

    List<ProfessorEntity> findAll();
}
