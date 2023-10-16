package com.healthmanagement.medicalapi.controller;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MedicalController {
    private final MedicalService medicalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medical saveMedical(@RequestBody Medical medical) {
        medical.setRegisterDate(OffsetDateTime.now());
        return
                medicalService.createMedical(medical);
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

    @GetMapping("/list/count")
    public ResponseEntity<Map<Integer, Integer>> countMedical() {
        final var map = medicalService.countMedicalByMonth();
        return ResponseEntity.ok().body(map);
    }

}
