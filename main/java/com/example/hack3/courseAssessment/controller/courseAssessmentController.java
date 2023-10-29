package com.example.hack3.courseAssessment.controller;

import com.example.hack3.courseAssessment.domain.courseAssessment;
import com.example.hack3.courseAssessment.domain.courseAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseAssessment")
public class courseAssessmentController {

    @Autowired
    private courseAssessmentRepository repository;

    @GetMapping
    public List<courseAssessment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<courseAssessment> getById(@PathVariable Long id) {
        Optional<courseAssessment> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public courseAssessment create(@RequestBody courseAssessment assessment) {
        return repository.save(assessment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<courseAssessment> update(@PathVariable Long id, @RequestBody courseAssessment updatedAssessment) {
        if (repository.existsById(id)) {
            updatedAssessment.setId(id); 
            return ResponseEntity.ok(repository.save(updatedAssessment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
