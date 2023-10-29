package com.example.hack3.student.controller;

import com.example.hack3.student.domain.student;
import com.example.hack3.student.domain.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class studentController {

    @Autowired
    private studentRepository repository;

    @GetMapping
    public List<student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<student> getById(@PathVariable Long id) {
        Optional<student> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public student create(@RequestBody student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<student> update(@PathVariable Long id, @RequestBody student updatedStudent) {
        if (repository.existsById(id)) {
            updatedStudent.setId(id); 
            return ResponseEntity.ok(repository.save(updatedStudent));
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
