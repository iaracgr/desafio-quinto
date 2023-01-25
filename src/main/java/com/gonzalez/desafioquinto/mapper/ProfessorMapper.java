package com.gonzalez.desafioquinto.mapper;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorMapper {

    public ProfessorResponse map (ProfessorEntity professorEntity){
        ProfessorResponse response = new ProfessorResponse();
       // response.setId(professorEntity.getProfessorId());
        response.setName(professorEntity.getName());
        response.setSurname(professorEntity.getSurname());
        response.setEmail(professorEntity.getEmail());
      //  response.setRole(professorEntity.getRole());
        response.setSoftDelete(professorEntity.getSoftDelete());
        List<String> names = new ArrayList<>();
        List<CourseEntity> courses = professorEntity.getCourses();
        for (CourseEntity course : courses){
            names.add(course.getName());
        }
        response.setCourses(names);
        return response;
    }

    public ProfessorEntity map (ProfessorRequest request, String password){
        ProfessorEntity professor = new ProfessorEntity();
        professor.setName(request.getName());
        professor.setSurname(request.getSurname());
        professor.setEmail(request.getEmail());
        professor.setCourseId(request.getIdCourse());
        professor.setProfessorId(request.getIdUser());
        professor.setPassword(password);
        return professor;
    }

    public List<ProfessorResponse> map (List<ProfessorEntity> professors){
        List<ProfessorResponse> list = new ArrayList<>(professors.size());
        for (ProfessorEntity professor : professors){
            list.add(map(professor));
        }
        return list;
    }
}
