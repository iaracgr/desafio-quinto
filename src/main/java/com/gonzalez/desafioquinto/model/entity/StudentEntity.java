package com.gonzalez.desafioquinto.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "student")
public class StudentEntity extends PersonEntity{

    @Column(name = "birthday")
    protected String birthday; // todo:change to calendar type

    @Column(name = "history")
    protected String history;

}
