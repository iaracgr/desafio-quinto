package com.gonzalez.desafioquinto.controller;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.request.StudentRequest;
import com.gonzalez.desafioquinto.model.request.UpdateProfessorRequest;
import com.gonzalez.desafioquinto.model.request.UpdateStudentRequest;
import com.gonzalez.desafioquinto.model.response.ListProfessorResponse;
import com.gonzalez.desafioquinto.model.response.ListStudentResponse;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;
import com.gonzalez.desafioquinto.model.response.StudentResponse;
import com.gonzalez.desafioquinto.service.abstraction.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping("/create")
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request) {
        StudentResponse response;
        try {
            response = iStudentService.create(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentResponse> update(@Valid @RequestBody UpdateStudentRequest request) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(iStudentService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws EntityNotFoundException {
        iStudentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("addCourse/{idCourse}/to/{idStudent}")
    public ResponseEntity<StudentResponse> addStudentToCourse(@PathVariable final String idCourse,
                                                              @PathVariable final String idStudent) {
        StudentResponse response;
        try {
            response = iStudentService.addStudentToCourse(idStudent, idCourse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/removeCourse/{idCourse}/from/{idStudent}")
    public ResponseEntity<StudentResponse> removeCourse(@PathVariable final String idCourse,
                                                          @PathVariable final String idStudent) {
        StudentResponse response = null;
        try {
            response = iStudentService.removeStudentFromCourse(idStudent, idCourse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<StudentEntity> findById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(iStudentService.getById(id));
    }

    @GetMapping("find/{name}")
    public ResponseEntity<StudentResponse> findByName(@PathVariable String name) throws EntityNotFoundException {
        return ResponseEntity.ok(iStudentService.getByNameAndSoftDeleteFalse(name));
    }

    @GetMapping("list")
    public ResponseEntity<ListStudentResponse> getAll() {
        return ResponseEntity.ok().body(iStudentService.getStudents());
    }
}
