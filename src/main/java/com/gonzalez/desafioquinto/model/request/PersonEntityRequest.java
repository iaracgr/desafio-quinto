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
public class PersonEntityRequest {

    @NotBlank(message = "First name cannot be empty or null.")
    private String firstName;

    @NotBlank(message = "Email cannot be empty or null.")
    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "Password cannot be empty or null.")
    @Size(min = 6,message="The password must be at least eight characters.")
    private String password;

    @NotBlank(message = "ROL cannot be empty or null.")
    private String rol;
}
