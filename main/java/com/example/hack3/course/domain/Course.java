package com.example.hack3.course.domain;

import jakarta.persistence.*;

import java.util.List;

import com.example.hack3.courseAssessment.domain.courseAssessment;
import com.example.hack3.courseType.domain.CourseType;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer credits;
    private String code;
    private String HRGroup;
    private Integer cycle;
    private String VRGroup;


    @ManyToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;    

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<courseAssessment> assessments;

    public Course() {}

    public Course(Long id, String name, Integer credits, String code, String HRGroup, Integer cycle, CourseType courseType, String VRGroup) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.code = code;
        this.HRGroup = HRGroup;
        this.cycle = cycle;
        this.courseType = courseType;
        this.VRGroup = VRGroup;
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

    public List<courseAssessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<courseAssessment> assessments) {
        this.assessments = assessments;
    }
    
}