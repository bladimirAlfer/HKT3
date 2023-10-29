package com.example.hack3.periodo.domain;

import jakarta.persistence.*;
import com.example.hack3.courseAssessment.domain.courseAssessment;
import java.util.List;

@Entity
@Table(name = "periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;

    @OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<courseAssessment> assessments;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<courseAssessment> getAssessments() {
        return assessments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAssessments(List<courseAssessment> assessments) {
        this.assessments = assessments;
    }
}
