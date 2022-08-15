package com.healthmanagement.medicalapi.controller;


import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MedicalController {
    private final MedicalService medicalService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Medical save(@RequestBody User user, Medical medical) {
//        return medicalService.createMedical(user, medical.getRecipe(),
//                medical.getEvolution());
//    }
//
//    @GetMapping
//    public Medical getMedical(@RequestBody User user) {
//        return medicalService.getMedical(user.getId());
//    }

    @GetMapping("/status")
    public String status() {
        return "Medical Api";
    }
}
