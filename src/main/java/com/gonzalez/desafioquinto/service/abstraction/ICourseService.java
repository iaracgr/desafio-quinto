package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.request.CourseRequest;
import com.gonzalez.desafioquinto.model.request.UpdateCourseRequest;
import com.gonzalez.desafioquinto.model.response.CourseResponse;
import com.gonzalez.desafioquinto.model.response.ListCourseResponse;

import javax.persistence.EntityNotFoundException;

public interface ICourseService {

    CourseResponse createCourse(CourseRequest request) throws Exception;

    CourseResponse updateCourse(UpdateCourseRequest request);

    ListCourseResponse getCourses() throws EntityNotFoundException;

    CourseResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException;

    CourseEntity getByIdAndSoftDeleteFalse(String id) throws EntityNotFoundException;



}
