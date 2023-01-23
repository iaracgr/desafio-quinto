package com.gonzalez.desafioquinto.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class PersonEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id")
    protected  String userId;

    @Column(name = "first_name",nullable = false)
     protected String name;

    @Column(name = "rol",nullable = false)
    protected String rol;

    @Column(name = "soft_delete",nullable = false)
    protected boolean softDelete=false;

    //todo: agregar atributo curso.
}
