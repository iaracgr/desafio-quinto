package com.gonzalez.desafioquinto.mapper;

import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import com.gonzalez.desafioquinto.model.request.StudentRequest;
import com.gonzalez.desafioquinto.model.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponse map (StudentEntity studentEntity){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setBirthday(studentEntity.getBirthday());
        studentResponse.setHistory(studentEntity.getHistory());
        return studentResponse;
    }

    public StudentEntity map(StudentRequest request){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setBirthday(request.getBirthday());
        studentEntity.setHistory(request.getHistory());
        return studentEntity;
    }

}
