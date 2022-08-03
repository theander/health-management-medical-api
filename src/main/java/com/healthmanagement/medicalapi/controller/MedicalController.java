package com.healthmanagement.medicalapi.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MedicalController {
    private final MedicalService medicalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medical save(@RequestBody User user, Medical medical) {
        return medicalService.createMedical(user, medical.getRecipe(),
                medical.getEvolution());
    }


    @GetMapping
    public Medical getMedical(@RequestBody User user) {
        return medicalService.getMedical(user);
    }

    @GetMapping("/status")
    public String status() {
        return "Medical Api";
    }
}
