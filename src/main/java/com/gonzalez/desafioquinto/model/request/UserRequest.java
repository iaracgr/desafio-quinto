package com.gonzalez.desafioquinto.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "First name cannot be empty or null.")
    private String name;

    @NotBlank(message = "Email cannot be empty or null.")
    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "ROLE cannot be empty or null.")
    private String role;
}
