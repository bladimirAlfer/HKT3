package com.example.hack3.course.controller;

import com.example.hack3.course.domain.Course;
import com.example.hack3.course.domain.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class courseController {

    @Autowired
    private courseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(course -> ResponseEntity.ok().body(course))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    existingCourse.setname(course.getname());
                    existingCourse.setcredits(course.getcredits());
                    //... 
                    final Course updatedCourse = courseRepository.save(existingCourse);
                    return ResponseEntity.ok().body(updatedCourse);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
