package com.gonzalez.desafioquinto.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("2")
public class StudentEntity extends UserEntity {

    @Column(name = "birthday")
    protected String birthday; // todo:change to calendar type

    @Column(name = "history")
    protected String history;

}
