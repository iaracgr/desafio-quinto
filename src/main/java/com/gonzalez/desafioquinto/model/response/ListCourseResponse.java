package com.gonzalez.desafioquinto.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListCourseResponse {
    private List<CourseResponse> courseResponses;
}
