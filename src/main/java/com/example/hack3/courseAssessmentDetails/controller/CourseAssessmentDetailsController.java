package com.example.hack3.courseAssessmentDetails.controller;

import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetails;
import com.example.hack3.courseAssessmentDetails.domain.courseAssessmentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {

    @Autowired
    private courseAssessmentDetailsRepository courseAssessmentDetailsRepository;

    @GetMapping
    public ResponseEntity<List<courseAssessmentDetails>> getAllCourseAssessmentDetails() {
        List<courseAssessmentDetails> courseAssessmentDetails = courseAssessmentDetailsRepository.findAll();
        return new ResponseEntity<>(courseAssessmentDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<courseAssessmentDetails> getCourseAssessmentDetailsById(@PathVariable Long id) {
        Optional<courseAssessmentDetails> courseAssessmentDetails = courseAssessmentDetailsRepository.findById(id);
        return courseAssessmentDetails.map(
            details -> new ResponseEntity<>(details, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<courseAssessmentDetails> createCourseAssessmentDetails(@RequestBody courseAssessmentDetails courseAssessmentDetails) {
        try {
            courseAssessmentDetails newCourseAssessmentDetails = courseAssessmentDetailsRepository.save(courseAssessmentDetails);
            return new ResponseEntity<>(newCourseAssessmentDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<courseAssessmentDetails> updateCourseAssessmentDetails(
            @PathVariable Long id, 
            @RequestBody courseAssessmentDetails courseAssessmentDetails
    ) {
        Optional<courseAssessmentDetails> existingCourseAssessmentDetailsOpt = courseAssessmentDetailsRepository.findById(id);
        if (existingCourseAssessmentDetailsOpt.isPresent()) {
            courseAssessmentDetails existingCourseAssessmentDetails = existingCourseAssessmentDetailsOpt.get();
            
            existingCourseAssessmentDetails.setscore(courseAssessmentDetails.getscore());
            existingCourseAssessmentDetails.setsection(courseAssessmentDetails.getsection());
            existingCourseAssessmentDetails.setsectionGroup(courseAssessmentDetails.getsectionGroup());
            
            courseAssessmentDetails updatedCourseAssessmentDetails = courseAssessmentDetailsRepository.save(existingCourseAssessmentDetails);
            return new ResponseEntity<>(updatedCourseAssessmentDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourseAssessmentDetails(@PathVariable Long id) {
        try {
            courseAssessmentDetailsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
