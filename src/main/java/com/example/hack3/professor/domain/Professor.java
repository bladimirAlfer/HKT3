package com.example.hack3.professor.domain;

import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column(name = "fullname")
    private String fullName;

    @OneToOne(mappedBy = "professor")
    private courseAssessmentDetails courseAssessmentDetails;

    public Professor() {}

    public Professor(String name, String lastName, String email, String fullName) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
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

}
