package com.example.hack3.courseType.domain;

import jakarta.persistence.*;

import com.example.hack3.course.domain.Course;

import java.util.List;

@Entity
@Table(name = "coursetype")
public class CourseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "courseType") 
    private List<Course> courses;


    public CourseType() {}

    public CourseType(Long id, String name) {
        this.id = id;
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
