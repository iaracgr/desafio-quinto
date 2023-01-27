package com.gonzalez.desafioquinto.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotBlank(message = "First name cannot be empty or null.")
    private String name;

    @NotBlank(message = "Email cannot be empty or null.")
    @Email(message = "Email is not valid.")
    private String email;

    private String role;

    private String age;

    private Date birthday;

    private String history;

    private String idCourse;

}
