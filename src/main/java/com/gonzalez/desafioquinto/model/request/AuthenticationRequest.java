package com.gonzalez.desafioquinto.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Getter
@Setter
public class AuthenticationRequest {

    @Email(message = "Email has invalid format.")
    @NotBlank(message = "Emails cannot be null or empty.")
    private String email;

    @NotBlank(message = "Password cannot be null or empty.")
    private String password;

}
