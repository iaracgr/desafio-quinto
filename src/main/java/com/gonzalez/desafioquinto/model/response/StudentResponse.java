package com.gonzalez.desafioquinto.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private String id;

    private String name;

    private String email;

    private String age;

    private String birthday;

    private String history;

    private String role;

    private List <String> courses;

    private Boolean softDelete;

}
