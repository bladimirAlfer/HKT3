package com.example.hack3.courseType.controller;

import com.example.hack3.courseType.domain.CourseType;
import com.example.hack3.courseType.domain.courseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coursetypes")

public class CourseTypeController {

    @Autowired
    private courseTypeRepository courseTypeRepository;

    @GetMapping
    public List<CourseType> getAllCourseTypes() {
        return courseTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseType> getCourseTypeById(@PathVariable Long id) {
        return courseTypeRepository.findById(id)
                .map(courseType -> ResponseEntity.ok().body(courseType))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CourseType createCourseType(@RequestBody CourseType courseType) {
        return courseTypeRepository.save(courseType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseType> updateCourseType(@PathVariable Long id, @RequestBody CourseType courseType) {
        return courseTypeRepository.findById(id)
                .map(existingCourseType -> {
                    existingCourseType.setName(courseType.getName());
                    final CourseType updatedCourseType = courseTypeRepository.save(existingCourseType);
                    return ResponseEntity.ok().body(updatedCourseType);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseType(@PathVariable Long id) {
        return courseTypeRepository.findById(id)
                .map(courseType -> {
                    courseTypeRepository.delete(courseType);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
