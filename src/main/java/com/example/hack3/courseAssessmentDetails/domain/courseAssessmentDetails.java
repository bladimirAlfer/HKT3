package com.example.hack3.courseAssessmentDetails.domain;

import jakarta.persistence.*;
import com.example.hack3.student.domain.student;
import com.example.hack3.professor.domain.Professor;
import com.example.hack3.courseAssessment.domain.courseAssessment;

@Entity
@Table(name = "course_assessment_details")
public class courseAssessmentDetails {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String score;
    private String section;
    private String sectionGroup;

    @OneToOne
    @JoinColumn(name = "course_assessment_id")
    private courseAssessment courseAssessment;


    @OneToOne
    @JoinColumn(name = "student_id")
    private student student;
    
    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    

    // Constructors
    public courseAssessmentDetails() {}

    public courseAssessmentDetails(String score, String section, String sectionGroup, student student, Professor professor, courseAssessment courseAssessment) {
        this.score = score;
        this.section = section;
        this.sectionGroup = sectionGroup;
        this.student = student;
        this.professor = professor;
        this.courseAssessment = courseAssessment;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getscore() {
        return score;
    }

    public void setscore(String score) {
        this.score = score;
    }

    public String getsection() {
        return section;
    }

    public void setsection(String section) {
        this.section = section;
    }
    public String getsectionGroup() {
        return sectionGroup;
    }

    public void setsectionGroup(String sectionGroup) {
        this.sectionGroup = sectionGroup;
    }
    public courseAssessment getCourseAssessment() {
        return courseAssessment;
    }

    public void setCourseAssessment(courseAssessment courseAssessment) {
        this.courseAssessment = courseAssessment;
    }

    public student getStudent() {
        return student;
    }

    public void setStudent(student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}