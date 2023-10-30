package com.example.hack3.periodo.controller;

import com.example.hack3.periodo.domain.Periodo;
import com.example.hack3.periodo.domain.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoRepository PeriodoRepository;

    @GetMapping
    public ResponseEntity<List<Periodo>> Periodo() {
        List<Periodo> periodos = PeriodoRepository.findAll();
        return new ResponseEntity<>(periodos, HttpStatus.OK);
    }

    // Crear nuevo detalle
    @PostMapping
    public ResponseEntity<Periodo> addPeriodo(@RequestBody Periodo Periodo) {
        Periodo newPeriodo = PeriodoRepository.save(Periodo);
        return new ResponseEntity<>(newPeriodo,HttpStatus.CREATED);
    }
}