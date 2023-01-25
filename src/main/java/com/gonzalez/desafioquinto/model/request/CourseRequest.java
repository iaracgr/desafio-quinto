package com.gonzalez.desafioquinto.model.request;

import com.gonzalez.desafioquinto.model.entity.ProfessorEntity;
import com.gonzalez.desafioquinto.model.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotBlank(message = "Course Name cannot be null or empty.")
    private String name;

    private String daytime;

    private String schedule;

}
