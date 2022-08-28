package com.healthmanagement.medicalapi.controller;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MedicalController {
    private final MedicalService medicalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medical saveMedical(@RequestBody Medical medical) {
        return medicalService.createMedical(medical);
    }

    @PutMapping("/list")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Medical updateMedical(@RequestBody Medical medical) {
        return medicalService.updateMedical(medical);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<Medical> getMedical(@RequestBody User user) {
        return medicalService.getMedical(user.getId());
    }

    @GetMapping("/status")
    public String status() {
        return "Medical Api";
    }
}
