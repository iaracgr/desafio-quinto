package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.mapper.CourseMapper;
import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.request.CourseRequest;
import com.gonzalez.desafioquinto.model.request.UpdateCourseRequest;
import com.gonzalez.desafioquinto.model.response.CourseResponse;
import com.gonzalez.desafioquinto.model.response.ListCourseResponse;
import com.gonzalez.desafioquinto.repository.ICourseRepository;
import com.gonzalez.desafioquinto.service.abstraction.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(CourseRequest request) throws Exception {
      if (nameExist(request.getName())== false){
          CourseEntity course = courseMapper.map(request);
      } else {
          throw new Exception("name is already in use");}
        CourseEntity course = courseMapper.map(request);
        return courseMapper.map(courseRepository.save(course));
    }

    public Boolean nameExist(String name) {
        Optional<CourseEntity> optional = Optional.ofNullable(courseRepository.findByName(name));
        if (optional.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public CourseResponse updateCourse(UpdateCourseRequest request) throws Exception {
        CourseEntity course = getByIdAndSoftDeleteFalse(request.getId());
        if (!course.getName().equals(request.getName())){
            if (!nameExist(request.getName())){
                course.setName(request.getName());
            } else {
                throw new Exception("name already exist.");
            }
            course.setName(request.getName());
        }
        course.setDaytime(request.getDaytime());
        course.setSchedule(request.getSchedule());
        return courseMapper.map(courseRepository.save(course));
    }

    private ListCourseResponse buildListResponse(List<CourseEntity> courses) {
        List<CourseResponse> courseResponses = courseMapper.map(courses);
        ListCourseResponse listCourseResponse = new ListCourseResponse();
        listCourseResponse.setCourseResponses(courseResponses);
        return listCourseResponse;
    }

    @Override
    public ListCourseResponse getCourses() throws EntityNotFoundException {
        List<CourseEntity> courses = courseRepository.findAll();
        return buildListResponse(courses);
    }

    @Transactional(rollbackFor = {Exception.class})
    public CourseEntity findByNameAndSoftDeleteFalse(String nameCourse) {
        Optional<CourseEntity> opt = Optional.ofNullable(courseRepository.findByName(nameCourse));
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Course not found");
        }
        return opt.get();
    }
    @Override
    public CourseResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException {
        return courseMapper.map(findByNameAndSoftDeleteFalse(name));

    }

    @Override
    public CourseEntity getByIdAndSoftDeleteFalse(String id) throws EntityNotFoundException {
        Optional<CourseEntity> opt = Optional.ofNullable(courseRepository.findByCourseIdAndSoftDeleteFalse(id));
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Course not found");
        }
        return opt.get();
    }

    @Override
    public void deleteCourse(String id) {
        CourseEntity course= getByIdAndSoftDeleteFalse(id);
        course.setSoftDelete(true);
        courseRepository.save(course);
    }
}
