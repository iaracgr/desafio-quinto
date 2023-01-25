package com.gonzalez.desafioquinto.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(name = "daytime") // turno: mañana,tarde,noche
    private String daytime;

    @Column(name = "schedule") // horario
    private String schedule;

    @JoinColumn(name = "course_id")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentEntity> studentsList = new ArrayList<>();

    @JoinColumn(name = "course_id")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProfessorEntity> professorsList =new ArrayList<>();

    @Column(name = "soft_delete",nullable = false)
    private boolean softDelete=false;

    public boolean isEnabled() { return !softDelete; }

    public void addStudent(StudentEntity student) {
        studentsList.add(student);
    }

    public void addBook(ProfessorEntity professor) {
        professorsList.add(professor);
    }

    public void removeBook(StudentEntity student) {
        studentsList.remove(student);
    }

    public void removeBook(ProfessorEntity professor) {
        professorsList.remove(professor);
    }

}
