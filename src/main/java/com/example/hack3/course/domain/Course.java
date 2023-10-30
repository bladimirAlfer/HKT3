package com.example.hack3.course.domain;

import jakarta.persistence.*;

import com.example.hack3.courseType.domain.CourseType;
import com.example.hack3.courseAssessment.domain.courseAssessment;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "credits")
    private Integer credits;
    private String code;
    private String HRGroup;
    private Integer cycle;
    private String VRGroup;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private courseAssessment courseAssessment;

    @OneToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;    


    public Course() {}

    public Course(String name, Integer credits, String code, String HRGroup, Integer cycle, String VRGroup) {
        this.name = name;
        this.credits = credits;
        this.code = code;
        this.HRGroup = HRGroup;
        this.cycle = cycle;
        this.VRGroup = VRGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Integer getcredits() {
        return credits;
    }

    public void setcredits(Integer credits) {
        this.credits = credits;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }    
    public String getHRGroup() {
        return HRGroup;
    }

    public void setHRGroup(String HRGroup) {
        this.HRGroup = HRGroup;
    }

    public Integer getcycle() {
        return cycle;
    }

    public void setcycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getVRGroup() {
        return VRGroup;
    }

    public void setVRGroup(String VRGroup) {
        this.VRGroup = VRGroup;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

}