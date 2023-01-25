package com.gonzalez.desafioquinto.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {
    private String id;

    private String name;

    private String age;

    private List<String> idCourse;

    private String birthday;

    private String history;

}
