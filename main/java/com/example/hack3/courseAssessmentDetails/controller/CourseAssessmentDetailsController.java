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
    public ResponseEntity<List<courseAssessmentDetails>> getAllDetails() {
        List<courseAssessmentDetails> details = courseAssessmentDetailsRepository.findAll();
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    // Obtener detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<courseAssessmentDetails> getDetailById(@PathVariable Long id) {
        Optional<courseAssessmentDetails> detail = courseAssessmentDetailsRepository.findById(id);
        if (detail.isPresent()) {
            return new ResponseEntity<>(detail.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear nuevo detalle
    @PostMapping
    public ResponseEntity<String> createDetail(@RequestBody courseAssessmentDetails detail) {
        courseAssessmentDetailsRepository.save(detail);
        return ResponseEntity.status(HttpStatus.CREATED).body("New item created");
    }

    // Actualizar detalle
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDetail(@PathVariable Long id, @RequestBody courseAssessmentDetails detail) {
        if (courseAssessmentDetailsRepository.existsById(id)) {
            detail.setId(id);
            courseAssessmentDetailsRepository.save(detail);
            return ResponseEntity.status(HttpStatus.OK).body("Item " + id + " updated");
        }
        return new ResponseEntity<>("Item " + id + " not found", HttpStatus.NOT_FOUND);
    }

    // Eliminar detalle
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDetail(@PathVariable Long id) {
        if (courseAssessmentDetailsRepository.existsById(id)) {
            courseAssessmentDetailsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Item " + id + " deleted");
        }
        return new ResponseEntity<>("Item " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
