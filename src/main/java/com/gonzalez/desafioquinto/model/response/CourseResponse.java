package com.gonzalez.desafioquinto.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private String courseId;

    private String name;

    private String daytime;

    private String schedule;

    private List<ProfessorResponse> professors;

    private List<StudentResponse> students;

    private Boolean softDelete;


}
