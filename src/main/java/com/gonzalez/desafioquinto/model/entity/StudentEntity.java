package com.gonzalez.desafioquinto.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "soft_delete",nullable = false)
    private Boolean softDelete=false;

    @Column(name = "age")
    private String age;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday; // todo:change to calendar type

    @Column(name = "history")
    private String history;

    @Column( name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "studentsList")
    private List<CourseEntity> courses;

    @Column(name = "course_id")
    private String courseId;
    public boolean isEnabled() { return !softDelete; }
    public void addCourse(CourseEntity course){courses.add(course);}
    public void removeCourse(CourseEntity course){courses.remove(course);}

}
