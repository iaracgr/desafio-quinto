package com.gonzalez.desafioquinto.repository;

import com.gonzalez.desafioquinto.model.entity.CourseEntity;
import com.gonzalez.desafioquinto.model.response.CourseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<CourseEntity,String> {

    CourseEntity findByCourseIdAndSoftDeleteFalse(String id);

    CourseEntity findByCourseId(String id);

    List<CourseEntity> findAll ();


}
