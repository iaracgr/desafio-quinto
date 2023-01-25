package com.gonzalez.desafioquinto.service.abstraction;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.request.UpdateProfessorRequest;
import com.gonzalez.desafioquinto.model.response.ListProfessorResponse;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface IProfessorService {

   // ProfessorResponse create (ProfessorRequest request) throws Exception;

    ProfessorResponse createProfessor (String idUser) throws Exception;

    ProfessorResponse addProfessorToCourse (String idProfessor, String idCourse) throws Exception;

    ProfessorResponse removeProfessorFromCourse ( String idProfessor, String idCourse) throws Exception;

    ProfessorResponse update (UpdateProfessorRequest request);

    ListProfessorResponse getProfessors ();

    ProfessorResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException;

    ProfessorEntity getByIdAndSoftDeleteFalse (String id) throws EntityNotFoundException;

    void deleteProfessor (String id) throws EntityNotFoundException;

}
