package com.gonzalez.desafioquinto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String name;

    @Column(name = "daytime") // turno
    private String daytime;

    @Column(name = "schedule") // horario: mañana,tarde,noche
    private String schedule;

    @Column(name = "students")
    @JoinColumn(name = "course_id")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<StudentEntity> studentsList;

    @Column(name = "professor")
    @JoinColumn(name = "course_id")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<ProfessorEntity> professorsList;

}
