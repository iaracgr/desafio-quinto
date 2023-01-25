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

    private String firstName;

    private String email;

    private String role;

    private Boolean softDelete;


}
