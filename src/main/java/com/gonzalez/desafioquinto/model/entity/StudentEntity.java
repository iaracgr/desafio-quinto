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
@Table(name = "student")
public class StudentEntity extends PersonEntity{

    @Column(name = "birthday")
    protected String birthday; // todo:change to calendar type

    @Column(name = "history")
    protected String history;

}
