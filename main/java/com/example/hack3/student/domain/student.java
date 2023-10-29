package com.example.hack3.student.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;

@Entity
@Table(name = "student")
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String code;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<courseAssessmentDetails> assessmentDetailsList = new ArrayList<>();


    // Constructors
    public student() {}

    public student(Long id, String name, String email, String code) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.code = code;
    }

    // Getters and Setters
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

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

        public List<courseAssessmentDetails> getAssessmentDetailsList() {
        return assessmentDetailsList;
    }

    public void setAssessmentDetailsList(List<courseAssessmentDetails> assessmentDetailsList) {
        this.assessmentDetailsList = assessmentDetailsList;
    }

    public void addAssessmentDetail(courseAssessmentDetails detail) {
        assessmentDetailsList.add(detail);
        detail.setStudent(this);
    }

    public void removeAssessmentDetail(courseAssessmentDetails detail) {
        assessmentDetailsList.remove(detail);
        detail.setStudent(null);
    }

}
