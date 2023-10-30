package com.example.hack3.course.controller;

import com.example.hack3.course.domain.Course;
import com.example.hack3.course.domain.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class courseController {

    @Autowired
    private courseRepository courseRepository;
    
    @GetMapping
    public ResponseEntity<List<Course>> Course() {
        List<Course> Course = courseRepository.findAll();
        return new ResponseEntity<>(Course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course Course) {
        Course newCourse = courseRepository.save(Course);
        return new ResponseEntity<>(newCourse,HttpStatus.CREATED);
    }
}
