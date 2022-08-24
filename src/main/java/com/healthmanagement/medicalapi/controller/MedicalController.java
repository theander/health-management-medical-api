package com.healthmanagement.medicalapi.controller;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MedicalController {
    private final MedicalService medicalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medical save(@RequestBody User user, Medical medical) {
        Long userId = user.getId();
        return medicalService.createMedical(userId, medical.getRecipe(),
                medical.getEvolution());
    }
//
    @GetMapping
    public Medical getMedical(@RequestBody User user) {
        return medicalService.getMedical(user.getId());
    }

    @GetMapping("/status")
    @Cacheable("medical")
    public String status() {
        log.info("Cache");
        return "Medical Api";
    }
}
