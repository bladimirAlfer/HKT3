package com.example.hack3.professor.controller;

import com.example.hack3.professor.domain.Professor;
import com.example.hack3.professor.domain.professorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professor")
public class professorController {

    @Autowired
    private professorRepository repository;

    @GetMapping
    public List<Professor> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getById(@PathVariable Long id) {
        Optional<Professor> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor) {
        return repository.save(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor updatedProfessor) {
        if (repository.existsById(id)) {
            updatedProfessor.setId(id); 
            return ResponseEntity.ok(repository.save(updatedProfessor));
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
