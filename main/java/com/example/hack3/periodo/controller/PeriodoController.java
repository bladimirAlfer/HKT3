package com.example.hack3.periodo.controller;

import com.example.hack3.periodo.domain.Periodo;
import com.example.hack3.periodo.domain.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoRepository periodoRepository;

    @GetMapping
    public ResponseEntity<List<Periodo>> getAllPeriodos() {
        List<Periodo> periodos = periodoRepository.findAll();
        return new ResponseEntity<>(periodos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periodo> getPeriodoById(@PathVariable Long id) {
        Optional<Periodo> periodo = periodoRepository.findById(id);
        if (periodo.isPresent()) {
            return new ResponseEntity<>(periodo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> createPeriodo(@RequestBody Periodo periodo) {
        periodoRepository.save(periodo);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePeriodo(@PathVariable Long id, @RequestBody Periodo updatedPeriodo) {
        Optional<Periodo> periodo = periodoRepository.findById(id);
        if (periodo.isPresent()) {
            Periodo currentPeriodo = periodo.get();
            currentPeriodo.setName(updatedPeriodo.getName());
            currentPeriodo.setCode(updatedPeriodo.getCode());
            periodoRepository.save(currentPeriodo);
            return ResponseEntity.status(200).body("Updated");
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePeriodo(@PathVariable Long id) {
        periodoRepository.deleteById(id);
        return ResponseEntity.status(200).body("Deleted");
    }
}
