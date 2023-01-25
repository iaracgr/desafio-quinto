package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import com.gonzalez.desafioquinto.model.request.StudentRequest;
import com.gonzalez.desafioquinto.model.request.UpdateStudentRequest;
import com.gonzalez.desafioquinto.model.response.ListStudentResponse;
import com.gonzalez.desafioquinto.model.response.StudentResponse;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public interface IStudentService {
    StudentResponse create (StudentRequest request) throws EntityExistsException;

    StudentResponse update (UpdateStudentRequest request);

    StudentResponse addStudentToCourse (String idStudent, String idCourse);

    StudentResponse removeStudentFromCourse (String idStudent, String idCourse);

    ListStudentResponse getStudents ();

    StudentResponse getByNameAndSoftDeleteFalse (String name) throws EntityNotFoundException;

    StudentEntity getById (String id) throws EntityNotFoundException;

    StudentResponse delete (String id) throws EntityNotFoundException;

}
