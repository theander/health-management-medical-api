package com.healthmanagement.medicalapi.controller;

import com.healthmanagement.medicalapi.model.Consulta;
import com.healthmanagement.medicalapi.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin
public class ConsultaController {
    private final ConsultaService consultaService;

    @PostMapping("/consulta")
    public ResponseEntity<Consulta> create(@RequestBody Consulta consulta) {

        Consulta savedConsulta = consultaService.createConsulta(consulta);
        return new ResponseEntity<>(savedConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/consulta")
    public ResponseEntity<List<Consulta>> getAll(@RequestParam(value = "username") String username) {

        List<Consulta> consultas = consultaService.consultas(username);
        return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
    }

    @PutMapping("/consulta/{id}/close")
    public ResponseEntity<Consulta> closeConsulta(@PathVariable(value = "id") Long id) {
        Consulta consulta = consultaService.closeConsulta(id);
        return new ResponseEntity<Consulta>(consulta, HttpStatus.NO_CONTENT);
    }
}
