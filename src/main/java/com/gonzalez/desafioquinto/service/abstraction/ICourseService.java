package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.request.CourseRequest;
import com.gonzalez.desafioquinto.model.request.UpdateCourseRequest;
import com.gonzalez.desafioquinto.model.response.CourseResponse;
import com.gonzalez.desafioquinto.model.response.ListCourseResponse;
import com.jayway.jsonpath.internal.filter.ValueNodes;

import javax.persistence.EntityNotFoundException;

public interface ICourseService {

    CourseResponse createCourse(CourseRequest request) throws Exception;

    CourseResponse updateCourse(UpdateCourseRequest request) throws Exception;

    ListCourseResponse getCourses() throws EntityNotFoundException;

    CourseResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException;

    CourseEntity getByIdAndSoftDeleteFalse(String id) throws EntityNotFoundException;

    void deleteCourse(String id);

}
