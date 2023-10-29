package com.example.hack3.professor.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String fullName;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<courseAssessmentDetails> assessmentDetailsList = new ArrayList<>();

    public Professor() {}

    public Professor(Long id, String name, String lastName, String email, String fullName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.fullName = fullName;
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

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public List<courseAssessmentDetails> getAssessmentDetailsList() {
        return assessmentDetailsList;
    }

    public void setAssessmentDetailsList(List<courseAssessmentDetails> assessmentDetailsList) {
        this.assessmentDetailsList = assessmentDetailsList;
    }

    public void addAssessmentDetail(courseAssessmentDetails detail) {
        assessmentDetailsList.add(detail);
        detail.setProfessor(this);
    }

    public void removeAssessmentDetail(courseAssessmentDetails detail) {
        assessmentDetailsList.remove(detail);
        detail.setProfessor(null);
    }
}
