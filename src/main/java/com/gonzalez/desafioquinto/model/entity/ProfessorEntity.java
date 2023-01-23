package com.gonzalez.desafioquinto.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "professor")
public class ProfessorEntity extends PersonEntity {

    @Column(name = "last_name", nullable = false)
    protected String surname;
}
git