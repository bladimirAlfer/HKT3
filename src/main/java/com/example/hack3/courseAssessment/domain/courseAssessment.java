package com.example.hack3.courseAssessment.domain;


import jakarta.persistence.*;

import com.example.hack3.course.domain.Course;
import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;
import com.example.hack3.periodo.domain.Periodo;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "course_assessment")
public class courseAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "course_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Course course;
    
    @OneToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;
    
    @Column
    private String title;
    
    @Column(name = "tipo_nota")
    private String tipoNota;
    @Column(name = "num_nota")
    private String numNota;
    @Column
    private String nomenclatura;
    @OneToOne(mappedBy = "courseAssessment")
    private courseAssessmentDetails courseAssessmentDetails;


    // Constructors
    public courseAssessment() {}

    public courseAssessment(String title, String tipoNota, String numNota, String nomenclatura, Course course, Periodo periodo) {
        this.title = title;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
        this.course = course;
        this.periodo = periodo;
    }

    // Getters and Setters

    public Long getId() {
        return id;
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
    public Periodo getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
}


