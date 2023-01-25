package com.gonzalez.desafioquinto.service;

import com.gonzalez.desafioquinto.mapper.ProfessorMapper;
import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.entity.UserEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.request.UpdateProfessorRequest;
import com.gonzalez.desafioquinto.model.response.*;
import com.gonzalez.desafioquinto.repository.IProfessorRepository;
import com.gonzalez.desafioquinto.service.abstraction.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    private IProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    @Autowired
    private UserServiceImpl userService;
    @Lazy
    @Autowired
    private CourseServiceImpl courseService;

   /* @Override
    public ProfessorResponse create(ProfessorRequest request) throws Exception {
        ProfessorEntity professor = professorMapper.map(request);
        ProfessorResponse response = professorMapper.map(professorRepository.save(professor));
        if (request.getIdUser().isEmpty()) {
            throw new IllegalArgumentException("you need to specified user");
        } else {
            UserResponse user = userService.getByEmail(request.getEmail());

        }
        ProfessorEntity professor = professorMapper.map(request);
        return professorMapper.map(professorRepository.save(professor));
    }*/


    public Boolean emailExist(String email) {
        Optional<ProfessorEntity> optional = Optional.ofNullable(professorRepository.findByEmailAndSoftDeleteFalse(email));
        if (optional.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ProfessorResponse createProfessor(String idUser) throws Exception {
        UserResponse user = userService.getById(idUser);
        ProfessorEntity professor = null;
        if (user.getDescription() == "PROFESSOR_STANDARD_USER") {
            professor = new ProfessorEntity();
            professor.setProfessorId(user.getUserId());
            professor.setName(user.getFirstName());
            professor.setEmail(user.getEmail());
            professor.setPassword(user.getPassword());
        } else {
            throw new Exception();
        }
        ProfessorResponse response = professorMapper.map(professorRepository.save(professor));
        return  response;
    }

    @Override
    public ProfessorResponse addProfessorToCourse(String idProfessor, String idCourse) throws Exception {
        ProfessorEntity professor = getByIdAndSoftDeleteFalse(idProfessor);
        CourseEntity course = courseService.getByIdAndSoftDeleteFalse(idCourse);
        if (course.getProfessorsList().contains(professor)) {
            throw new Exception("this professor is already assigned to this course.");
        }
        professor.addCourse(course);
        course.addProfessor(professor);
        return professorMapper.map(professor);
    }

    @Override
    public ProfessorResponse removeProfessorFromCourse(String idProfessor, String idCourse) throws Exception {
        ProfessorEntity professor = getByIdAndSoftDeleteFalse(idProfessor);
        CourseEntity course = courseService.getByIdAndSoftDeleteFalse(idCourse);
        if (!course.getProfessorsList().contains(professor)) {
            throw new Exception("this professor does not have this course.");
        }
        professor.removeCourse(course);
        course.removeProfessor(professor);
        return professorMapper.map(professor);
    }

    @Override
    public ProfessorResponse update(UpdateProfessorRequest request) {
        ProfessorEntity professor = getByIdAndSoftDeleteFalse(request.getIdProfessor());
        professor.setName(request.getName());
        professor.setSurname(request.getSurname());
        List<CourseEntity> courses = new ArrayList<>();
        for (String courseId : request.getIdCourse()) {
            CourseEntity course = courseService.getByIdAndSoftDeleteFalse(courseId);
            courses.add(course);
        }
        professor.setCourses(courses);
        return professorMapper.map(professor);
    }

    private ListProfessorResponse buildListResponse(List<ProfessorEntity> professors) {
        List<ProfessorResponse> responses = professorMapper.map(professors);
        ListProfessorResponse list = new ListProfessorResponse();
        list.setList(responses);
        return list;
    }

    @Override
    public ListProfessorResponse getProfessors() {
        List<ProfessorEntity> professors = professorRepository.findAll();
        return buildListResponse(professors);
    }

    @Transactional(rollbackFor = {Exception.class})
    public ProfessorEntity findByNameAndSoftDeleteFalse(String name) {
        Optional<ProfessorEntity> opt = Optional.ofNullable(professorRepository.findByName(name));
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Professor not found");
        }
        return opt.get();
    }

    @Override
    public ProfessorResponse getByNameAndSoftDeleteFalse(String name) throws EntityNotFoundException {
        return professorMapper.map(findByNameAndSoftDeleteFalse(name));
    }

    @Override
    public ProfessorEntity getByIdAndSoftDeleteFalse(String id) throws EntityNotFoundException {
        Optional<ProfessorEntity> opt = Optional.ofNullable(professorRepository.findByProfessorIdAndSoftDeleteFalse(id));
        if (opt.isEmpty()) {
            throw new EntityNotFoundException("Course not found");
        }
        return opt.get();
    }

    @Override
    public void deleteProfessor(String id) throws EntityNotFoundException {
        ProfessorEntity professor = getByIdAndSoftDeleteFalse(id);
        professor.setSoftDelete(true);
        professorRepository.save(professor);
    }
}
