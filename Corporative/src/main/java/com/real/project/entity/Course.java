package com.real.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "exchange_rates")

public class Course implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "exchange_course")
    private Double exchange_course;


    public Double getExchange_course() {
        return exchange_course;
    }

    public void setExchange_course(Double exchange_course) {
        this.exchange_course = exchange_course;
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "exchange_course=" + exchange_course +
                ", id=" + id +
                '}';
    }
}


