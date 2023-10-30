package com.example.hack3.courseType.controller;

import com.example.hack3.courseType.domain.CourseType;
import com.example.hack3.courseType.domain.courseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coursetypes")

public class CourseTypeController {

    @Autowired
    private courseTypeRepository courseTypeRepository;

    @GetMapping
    public ResponseEntity<List<CourseType>> CourseType() {
        List<CourseType> CourseType = courseTypeRepository.findAll();
        return new ResponseEntity<>(CourseType, HttpStatus.OK);
    }

    // Crear nuevo detalle
    @PostMapping
    public ResponseEntity<CourseType> addCourseType(@RequestBody CourseType CourseType) {
        CourseType newCourseType = courseTypeRepository.save(CourseType);
        return new ResponseEntity<>(newCourseType,HttpStatus.CREATED);
    }
}
