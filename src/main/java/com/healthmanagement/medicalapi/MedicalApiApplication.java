package com.healthmanagement.medicalapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(MedicalService medicalService) {
//        return args -> {
//            User user = new User();
//            user.setId(123l);
//            user.setFullName("User Name");
//Medical medical
//         =new Medical();
//medical.setUserId(123l);
//medical.setEvolution("asdasd");
//medical.setRecipe("sdf");
//
//            medicalService.createMedical(medical);
//        };
//    }


}
