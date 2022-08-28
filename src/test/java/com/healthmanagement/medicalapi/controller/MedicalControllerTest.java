package com.healthmanagement.medicalapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthmanagement.medicalapi.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(MedicalController.class)
public class MedicalControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    //@Test
    void testSaveMedical() throws Exception {

    }

    //@Test
    void updateMedical() {
    }

    @Test
    void testGetMedical() throws Exception {
        User user = User.builder().id(5l).build();
        String userJson = objectMapper.writeValueAsString(user);
        mockMvc.perform(get("/api").content(userJson).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
