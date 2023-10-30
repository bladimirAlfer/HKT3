package com.example.hack3.professor.controller;

import com.example.hack3.professor.domain.Professor;
import com.example.hack3.professor.domain.professorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class professorController {

    @Autowired
    private professorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<Professor>> student() {
        List<Professor> students = professorRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Crear nuevo detalle
    @PostMapping
    public ResponseEntity<Professor> addstudent(@RequestBody Professor Professor) {
        Professor newProfessor = professorRepository.save(Professor);
        return new ResponseEntity<>(newProfessor,HttpStatus.CREATED);
    }
}