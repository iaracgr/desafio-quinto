package com.gonzalez.desafioquinto.controller;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.request.ProfessorRequest;
import com.gonzalez.desafioquinto.model.request.UpdateProfessorRequest;
import com.gonzalez.desafioquinto.model.request.UpdateUserRequest;
import com.gonzalez.desafioquinto.model.response.ListProfessorResponse;
import com.gonzalez.desafioquinto.model.response.ListUserResponse;
import com.gonzalez.desafioquinto.model.response.ProfessorResponse;
import com.gonzalez.desafioquinto.model.response.UserResponse;
import com.gonzalez.desafioquinto.service.abstraction.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService iProfessorService;

/*    @PostMapping("/create")
    public ResponseEntity<ProfessorResponse> create(@RequestBody ProfessorRequest request) {
        ProfessorResponse response;
        try {
            response = iProfessorService.create(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }*/

    @PostMapping("/create")
    public ResponseEntity<ProfessorResponse> create (@PathVariable String idUser){
        ProfessorResponse response = null;
        try {
            response = iProfessorService.createProfessor(idUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ProfessorResponse> update(@Valid @RequestBody UpdateProfessorRequest request) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(iProfessorService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws EntityNotFoundException {
        iProfessorService.deleteProfessor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("addCourse/{idCourse}/to/{idProfessor}")
    public ResponseEntity<ProfessorResponse> addProfessorToCourse(@PathVariable final String idCourse,
                                                                  @PathVariable final String idProfessor) {
        ProfessorResponse response;
        try {
            response = iProfessorService.addProfessorToCourse(idProfessor, idCourse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/removeCourse/{idCourse}/from/{idProfessor}")
    public ResponseEntity<ProfessorResponse> removeCourse(@PathVariable final String idCourse,
                                                          @PathVariable final String idProfessor) {
        ProfessorResponse response = null;
        try {
            response = iProfessorService.removeProfessorFromCourse(idProfessor, idCourse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<ProfessorEntity> findById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(iProfessorService.getByIdAndSoftDeleteFalse(id));
    }

    @GetMapping("find/{name}")
    public ResponseEntity<ProfessorResponse> findByName(@PathVariable String name) throws EntityNotFoundException {
        return ResponseEntity.ok(iProfessorService.getByNameAndSoftDeleteFalse(name));
    }

    @GetMapping("list")
    public ResponseEntity<ListProfessorResponse> getAll() {
        return ResponseEntity.ok().body(iProfessorService.getProfessors());
    }


}
