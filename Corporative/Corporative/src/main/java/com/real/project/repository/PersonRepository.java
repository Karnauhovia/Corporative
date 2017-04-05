package com.real.project.repository;

import com.real.project.entity.Course;
import com.real.project.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query("SELECT p FROM Person p WHERE p.shows = :shows")
    List<Person> findAllpers(@Param("shows") int ParamShows);

    @Query("SELECT p FROM Person p WHERE p.count <> 0 AND p.shows = 0")
    List<Person> findDebtpers();

}
