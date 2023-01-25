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

    ProfessorResponse create (ProfessorRequest request) throws EntityExistsException;

    ProfessorResponse addProfessorToCourse (String idProfessor, String idCourse);

    ProfessorResponse deleteProfessorFromCourse ( String idProfessor, String idCourse);

    ProfessorResponse update (UpdateProfessorRequest request);

    ListProfessorResponse getProfessors ();

    ProfessorResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException;

    ProfessorEntity getByIdAndSoftDeleteFalse (String id) throws EntityNotFoundException;

    ProfessorResponse delete(String id) throws EntityNotFoundException;

}
