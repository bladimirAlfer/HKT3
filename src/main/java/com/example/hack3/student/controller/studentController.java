package com.example.hack3.student.controller;

import com.example.hack3.student.domain.student;
import com.example.hack3.student.domain.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    private studentRepository studentRepository;


    @GetMapping
    public ResponseEntity<List<student>> student() {
        List<student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Crear nuevo detalle
    @PostMapping
    public ResponseEntity<student> addstudent(@RequestBody student student) {
        student newstudent = studentRepository.save(student);
        return new ResponseEntity<>(newstudent,HttpStatus.CREATED);
    }
}
