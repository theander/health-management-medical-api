package com.healthmanagement.medicalapi;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class MedicalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(MedicalService medicalService) {
        return args -> {
            User user = new User();
            user.setId(123l);
            user.setFullName("User Name");




            medicalService.createMedical(user, "No fever", "paracetamol");
        };
    }

    ;
}
