package com.gonzalez.desafioquinto.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class UserEntity { // perfil administrador

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id")
    private   String userId;

    @Column(name = "first_name",nullable = false)
     private String name;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "soft_delete",nullable = false)
    private boolean softDelete=false;

    public boolean isEnabled() { return !softDelete; }

}
