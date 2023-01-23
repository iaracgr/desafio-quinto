package com.gonzalez.desafioquinto.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class ProfessorEntity extends PersonEntity {

    @Column(name = "last_name", nullable = false)
    protected String surname;
}