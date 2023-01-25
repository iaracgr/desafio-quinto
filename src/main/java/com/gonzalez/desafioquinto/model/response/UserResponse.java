package com.gonzalez.desafioquinto.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String userId;

    private String name;

    private String email;

    private String role;

    private String description;

    private String token;

    private String password;

    private Boolean softDelete;


}
