package com.gonzalez.desafioquinto.mapper;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import com.gonzalez.desafioquinto.model.entity.UserEntity;
import com.gonzalez.desafioquinto.model.request.StudentRequest;
import com.gonzalez.desafioquinto.model.response.StudentResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public StudentResponse map (StudentEntity studentEntity){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentEntity.getStudentId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setEmail(studentEntity.getEmail());
        studentResponse.setAge(studentEntity.getAge());
        studentResponse.setBirthday(studentEntity.getBirthday());
        studentResponse.setHistory(studentEntity.getHistory());
        studentResponse.setSoftDelete(studentEntity.getSoftDelete());
        studentResponse.setRole(studentEntity.getRole());
        List<String> names = new ArrayList<>();
        List<CourseEntity> courses= studentEntity.getCourses();
        for (CourseEntity course : courses){
            names.add(course.getName());
        }
        studentResponse.setCourses(names);
        return studentResponse;
    }

    public StudentEntity map(StudentRequest request){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(request.getName());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setAge(request.getAge());
        studentEntity.setBirthday(request.getBirthday());
        studentEntity.setHistory(request.getHistory());
        studentEntity.setCourseId(request.getIdCourse());
        studentEntity.setRole(request.getRole());
        return studentEntity;
    }

    public List<StudentResponse> map(List<StudentEntity> students) {
        List<StudentResponse> responses = new ArrayList<>(students.size());
        for (StudentEntity student : students) {
            responses.add(map(student));
        }
        return responses;
    }
}
