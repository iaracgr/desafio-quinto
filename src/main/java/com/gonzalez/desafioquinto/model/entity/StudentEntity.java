package com.gonzalez.desafioquinto.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "student_id")
    private   String studentId;

    @Column(name = "first_name",nullable = false)
    private String name;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "soft_delete",nullable = false)
    private boolean softDelete=false;

    @Column(name = "birthday")
    private String birthday; // todo:change to calendar type

    @Column(name = "history")
    private String history;

    @Column(name ="student_courses" )
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<CourseEntity> courses;

    @Column(name = "course_id")
    private String courseId;
    public boolean isEnabled() { return !softDelete; }


}
