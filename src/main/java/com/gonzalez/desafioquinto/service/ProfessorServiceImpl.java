package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.request.UpdateProfessorRequest;
import com.gonzalez.desafioquinto.model.response.ListProfessorResponse;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;
import com.gonzalez.desafioquinto.service.abstraction.IProfessorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
public class ProfessorServiceImpl implements IProfessorService {
    @Override
    public ProfessorResponse create(ProfessorRequest request) throws EntityExistsException {
        return null;
    }

    @Override
    public ProfessorResponse addProfessorToCourse(String idProfessor, String idCourse) {
        return null;
    }

    @Override
    public ProfessorResponse deleteProfessorFromCourse(String idProfessor, String idCourse) {
        return null;
    }

    @Override
    public ProfessorResponse update(UpdateProfessorRequest request) {
        return null;
    }

    @Override
    public ListProfessorResponse getProfessors() {
        return null;
    }

    @Override
    public ProfessorResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException {
        return null;
    }

    @Override
    public ProfessorEntity getByIdAndSoftDeleteFalse(String id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public ProfessorResponse delete(String id) throws EntityNotFoundException {
        return null;
    }
}
