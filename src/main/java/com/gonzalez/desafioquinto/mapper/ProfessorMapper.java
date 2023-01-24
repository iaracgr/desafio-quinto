package com.gonzalez.desafioquinto.mapper;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorResponse map (ProfessorEntity professorEntity){
        ProfessorResponse response = new ProfessorResponse();
        response.setSurname(professorEntity.getSurname());
        return response;
    }

    public ProfessorEntity map (ProfessorRequest request){
        ProfessorEntity professor = new ProfessorEntity();
        professor.setSurname(request.getSurname());
        return professor;
    }
}
