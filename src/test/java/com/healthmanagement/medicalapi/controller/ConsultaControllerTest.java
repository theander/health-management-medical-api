package com.healthmanagement.medicalapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthmanagement.medicalapi.model.Consulta;
import com.healthmanagement.medicalapi.model.ConsultaStatusEnum;
import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.service.ConsultaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConsultaController.class)
@ActiveProfiles("test")
class ConsultaControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private ConsultaService consultaService;

    @Test
    void create() throws Exception {
        Consulta consulta = this.dummyConsulta();
        consulta.setId(123l);
        Consulta consulta1 = this.dummyConsulta();
        String content = objectMapper.writeValueAsString(consulta1);
        when(consultaService.createConsulta(any())).thenReturn(consulta);
        mockMvc.perform(post("/api/consulta")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andReturn();
        verify(consultaService, times(1)).createConsulta(any());
    }

    @Test
    void getAll() throws Exception {
        Consulta consulta = this.dummyConsulta();
        consulta.setId(123l);
        Consulta consulta1 = this.dummyConsulta();
        String content = objectMapper.writeValueAsString(consulta1);
        when(consultaService.consultas(any(),any(),any())).thenReturn(Arrays.asList(consulta));
        mockMvc.perform(get("/api/consulta")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("username","usr")
                        .param("medico","mdc")
                        .param("status","sts")
                        .content(content)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]").isNotEmpty())
                .andReturn();
        verify(consultaService, times(1)).consultas(any(),any(),any());
    }

    @Test
    void closeConsulta() throws Exception {
        Consulta consulta = this.dummyConsulta();
        consulta.setId(123l);
        consulta.setConsultaStatusEnum(ConsultaStatusEnum.CLOSED);

        when(consultaService.closeConsulta(any())).thenReturn(consulta);
        mockMvc.perform(put("/api/consulta/{id}/close",123)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)

                )
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.consultaStatusEnum").value(String.valueOf(ConsultaStatusEnum.CLOSED)))
                .andReturn();
        verify(consultaService, times(1)).closeConsulta(any());
    }
private Consulta dummyConsulta(){
        return Consulta.builder().medico("Jose").username("pedrinho").description("Consulta medica").build();
}
}