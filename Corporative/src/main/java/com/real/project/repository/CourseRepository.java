package com.real.project.repository;

import com.real.project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("SELECT exchange_course FROM Course c WHERE id = 1")
    Double GetCourse();

}

