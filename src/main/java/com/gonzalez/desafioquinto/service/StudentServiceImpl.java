package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import com.gonzalez.desafioquinto.model.request.StudentRequest;
import com.gonzalez.desafioquinto.model.request.UpdateStudentRequest;
import com.gonzalez.desafioquinto.model.response.ListStudentResponse;
import com.gonzalez.desafioquinto.model.response.StudentResponse;
import com.gonzalez.desafioquinto.service.abstraction.IStudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {
    @Override
    public StudentResponse create(StudentRequest request) throws EntityExistsException {
        return null;
    }

    @Override
    public StudentResponse update(UpdateStudentRequest request) {
        return null;
    }

    @Override
    public StudentResponse addStudentToCourse(String idStudent, String idCourse) {
        return null;
    }

    @Override
    public StudentResponse removeStudentFromCourse(String idStudent, String idCourse) {
        return null;
    }

    @Override
    public ListStudentResponse getStudents() {
        return null;
    }

    @Override
    public StudentResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException {
        return null;
    }

    @Override
    public StudentEntity getById(String id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public StudentResponse delete(String id) throws EntityNotFoundException {
        return null;
    }
}
