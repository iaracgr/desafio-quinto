package com.gonzalez.desafioquinto.controller;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.request.CourseRequest;
import com.gonzalez.desafioquinto.model.request.UpdateCourseRequest;
import com.gonzalez.desafioquinto.model.response.CourseResponse;
import com.gonzalez.desafioquinto.model.response.ListCourseResponse;
import com.gonzalez.desafioquinto.service.abstraction.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    ICourseService iCourseService;

    @PostMapping("/create")
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest request) {
        try {
            CourseResponse response = iCourseService.createCourse(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/updated")
    public ResponseEntity<CourseResponse> updateCourse(@RequestBody UpdateCourseRequest request) throws Exception{
        iCourseService.updateCourse(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable String id) {
        iCourseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CourseEntity> getById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(iCourseService.getByIdAndSoftDeleteFalse(id));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<CourseResponse> getByName(@PathVariable String name) throws EntityNotFoundException {
        return ResponseEntity.ok().body(iCourseService.getByNameAndSoftDeleteFalse(name));
    }

    @GetMapping("/list")
    public ResponseEntity<ListCourseResponse> getCourses() throws EntityNotFoundException {
        return ResponseEntity.ok().body(iCourseService.getCourses());
    }

}
