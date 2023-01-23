package com.gonzalez.desafioquinto.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id")
    protected  String userId;

    @Column(name = "first_name",nullable = false)
     protected String name;

    @Column(name = "role",nullable = false)
    protected String role;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "soft_delete",nullable = false)
    protected boolean softDelete=false;

    //todo: agregar atributo curso.
}
