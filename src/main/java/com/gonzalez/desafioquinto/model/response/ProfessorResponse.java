package com.gonzalez.desafioquinto.model.response;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponse {

    private String id;

    private String name;

    private String surname;

    private String email;

    private String role;

    private List<String> courses;

    private Boolean softDelete;


}
