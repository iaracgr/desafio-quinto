package com.gonzalez.desafioquinto.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("1")
public class ProfessorEntity extends UserEntity {

    @Column(name = "last_name", nullable = false)
    protected String surname;
}