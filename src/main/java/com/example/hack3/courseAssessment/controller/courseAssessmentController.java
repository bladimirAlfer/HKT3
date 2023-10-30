package com.example.hack3.courseAssessment.controller;

import com.example.hack3.course.domain.Course;
import com.example.hack3.course.domain.courseRepository;
import com.example.hack3.courseAssessment.domain.courseAssessment;
import com.example.hack3.courseAssessment.domain.courseAssessmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course_assessment")
public class courseAssessmentController {

    private final courseAssessmentRepository courseAssessmentRepository;
    private final courseRepository courseRepository;

    
    public courseAssessmentController(courseAssessmentRepository courseAssessmentRepository, courseRepository courseRepository) {
        this.courseAssessmentRepository = courseAssessmentRepository;
        this.courseRepository = courseRepository;
    }
    @GetMapping
    public ResponseEntity<List<courseAssessment>> courseAssessment() {
        List<courseAssessment> courseAssessment = courseAssessmentRepository.findAll();
        return new ResponseEntity<>(courseAssessment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<courseAssessment> addcourseAssessment(@RequestBody courseAssessment courseAssessment) {
        if(courseAssessment.getCourse() != null && courseAssessment.getCourse().getId() != null){
            Course course = courseRepository.findById(courseAssessment.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
            courseAssessment.setCourse(course);
        }
        courseAssessment newcourseAssessment = courseAssessmentRepository.save(courseAssessment);
        return new ResponseEntity<>(newcourseAssessment, HttpStatus.CREATED);
    }

}
