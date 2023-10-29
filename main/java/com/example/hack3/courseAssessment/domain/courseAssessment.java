package com.example.hack3.courseAssessment.domain;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.example.hack3.course.domain.Course;
import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;
import com.example.hack3.periodo.domain.Periodo;

@Entity
@Table(name = "course_assessment")
public class courseAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String tipoNota;
    private String numNota;
    private String nomenclatura;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
        @OneToMany(mappedBy = "courseAssessment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<courseAssessmentDetails> assessmentDetails = new ArrayList<>();

    
    // Constructors
    public courseAssessment() {}

    public courseAssessment(Long id, String title, String tipoNota, String numNota, String nomenclatura, Course course, Periodo periodo) {
        this.id = id;
        this.title = title;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
        this.course = course;
        this.periodo = periodo;
    }

    // Getters and Setters

    public List<courseAssessmentDetails> getAssessmentDetails() {
        return assessmentDetails;
    }

    public void setAssessmentDetails(List<courseAssessmentDetails> assessmentDetails) {
        this.assessmentDetails = assessmentDetails;
    }

    public void addAssessmentDetail(courseAssessmentDetails detail) {
        assessmentDetails.add(detail);
        detail.setCourseAssessment(this);
    }

    public void removeAssessmentDetail(courseAssessmentDetails detail) {
        assessmentDetails.remove(detail);
        detail.setCourseAssessment(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String gettipoNota() {
        return tipoNota;
    }

    public void settipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public String getnumNota() {
        return numNota;
    }

    public void setnumNota(String numNota) {
        this.numNota = numNota;
    }

    
    public String getnomenclatura() {
        return nomenclatura;
    }

    public void setnomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

}
