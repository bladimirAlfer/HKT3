package com.example.hack3.student.domain;

import jakarta.persistence.*;

import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;

@Entity
@Table(name = "students")
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column(name = "code")
    private String code;

    @OneToOne(mappedBy = "student")
    private courseAssessmentDetails courseAssessmentDetails;

    public student() {}

    public student(String name, String email, String code) {
        this.name = name;
        this.email = email;
        this.code = code;
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


    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}