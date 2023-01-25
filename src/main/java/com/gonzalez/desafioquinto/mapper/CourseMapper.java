package com.gonzalez.desafioquinto.mapper;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.request.CourseRequest;
import com.gonzalez.desafioquinto.model.response.CourseResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

    public CourseResponse map(CourseEntity course) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourseId(course.getCourseId());
        courseResponse.setName(course.getName());
        courseResponse.setDaytime(course.getDaytime());
        courseResponse.setSchedule(course.getSchedule());
        courseResponse.setSoftDelete(course.getSoftDelete());
        List<String> names = new ArrayList<>();
        List<ProfessorEntity> professors = course.getProfessorsList();
        for (ProfessorEntity professor : professors){
            names.add(professor.getName());
        }
        courseResponse.setProfessorsName(names);
        return courseResponse;
    }
    public CourseEntity map(CourseRequest request) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(request.getName());
        courseEntity.setDaytime(request.getDaytime());
        courseEntity.setSchedule(request.getSchedule());
        return courseEntity;
    }
    public List<CourseResponse> map(List<CourseEntity> courses) {
        List<CourseResponse> courseResponses = new ArrayList<>(courses.size());
        for (CourseEntity course : courses) {
            courseResponses.add(map(course));
        }
        return courseResponses;
    }
}
