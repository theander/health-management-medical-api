package com.healthmanagement.medicalapi.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class MedicalController {
    @GetMapping("/status")
    public String status(){
        return  "Medical Api";
    }
}
