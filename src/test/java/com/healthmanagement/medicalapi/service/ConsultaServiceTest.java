package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Consulta;
import com.healthmanagement.medicalapi.model.ConsultaStatusEnum;
import com.healthmanagement.medicalapi.repository.ConsultaRepository;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.healthmanagement.medicalapi.model.ConsultaStatusEnum.CLOSED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ConsultaServiceTest {
    @Mock
    ConsultaRepository consultaRepository;
    @InjectMocks
    ConsultaService consultaService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultaById() {

        Consulta consulta2 = this.dummyConsulta();
        consulta2.setId(1l);
        when(consultaRepository.findById(any())).thenReturn(Optional.of(consulta2));

        Consulta consulta = consultaService.consultaById(1l);
        assertThat(consulta.getId()).isNotNull();
    }

    @Test
    void getNullWithConsultaById() {

        when(consultaRepository.findById(any())).thenReturn(Optional.empty());

        Consulta consulta = consultaService.consultaById(1l);
        assertThat(consulta).isNull();
    }
    @Test
    void consultasMedicoisEmpty() {
        Consulta consulta2 = this.dummyConsulta();
        consulta2.setId(1l);
        when(consultaRepository.findAllByUsernameEqualsAndConsultaStatusEnumEquals(any(),any())).thenReturn(Arrays.asList(consulta2));

        List<Consulta> consulta = consultaService.consultas(null,null,"OPEN");
        assertThat(consulta).isNotNull();
        assertThat(consulta.size()).isGreaterThan(0);

    }
    @Test
    void consultasMedicoisNotEmpty() {
        Consulta consulta2 = this.dummyConsulta();
        consulta2.setId(1l);
        when(consultaRepository.findAllByMedicoEqualsAndConsultaStatusEnumEquals(any(),any())).thenReturn(Arrays.asList(consulta2));

        List<Consulta> consulta = consultaService.consultas(null,"pedro","OPEN");
        assertThat(consulta).isNotNull();
        assertThat(consulta.size()).isGreaterThan(0);

    }

    @Test
    void createConsulta() {
        Consulta consulta1 = this.dummyConsulta();
        consulta1.setConsultaStatusEnum(null);
        Consulta consulta2 = this.dummyConsulta();
        consulta2.setId(1l);

        when(consultaRepository.save(any())).thenReturn(consulta2);

        Consulta consulta = consultaService.createConsulta(consulta1);
        assertThat(consulta.getId()).isNotNull();



    }

    @Test
    void closeConsulta() {
        Consulta consulta1 = this.dummyConsulta();
        consulta1.setConsultaStatusEnum(null);
        Consulta consulta2 = this.dummyConsulta();
        consulta2.setId(1l);
        consulta2.setConsultaStatusEnum(CLOSED);

        when(consultaRepository.findById(any())).thenReturn(Optional.of(consulta1));
        when(consultaRepository.save(any())).thenReturn(consulta2);

        Consulta consulta = consultaService.closeConsulta(1l);
        assertThat(consulta.getId()).isNotNull();
        assertThat(consulta.getConsultaStatusEnum()).isEqualTo(CLOSED);


    }

    private Consulta dummyConsulta() {
        return Consulta.builder().username("jose").medico("pedro").description("consulta do Jose com o medico Pedro").build();
    }
}