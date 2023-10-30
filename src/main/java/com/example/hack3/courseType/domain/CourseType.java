package com.example.hack3.courseType.domain;

import jakarta.persistence.*;

import com.example.hack3.course.domain.Course;


@Entity
@Table(name = "coursetype")
public class CourseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "courseType")
    private Course course;


    public CourseType() {}

    public CourseType(String name) {
        this.name = name;
    }

    public Long getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
