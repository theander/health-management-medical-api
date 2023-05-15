package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Consulta;
import com.healthmanagement.medicalapi.model.ConsultaStatusEnum;
import com.healthmanagement.medicalapi.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;


    public Consulta consultaById(Long id) {
        Optional<Consulta> consultaById = consultaRepository.findById(id);
        if (consultaById.isPresent()) {
            return consultaById.get();
        }
        return null;
    }

    public List<Consulta> consultas(String username, String medico, String status) {
        if (username == null) {
            username = "";
        }
        if (medico == null) {
            medico = "";
        }
        return consultaRepository.findAllByUsernameEqualsOrMedicoEqualsAndConsultaStatusEnumEquals(username,medico,ConsultaStatusEnum.valueOf(status));
    }

    public Consulta createConsulta(Consulta consulta) {
        if (consulta.getConsultaStatusEnum() == null) {
            consulta.setConsultaStatusEnum(ConsultaStatusEnum.OPEN);
        }
        return consultaRepository.save(consulta);
    }

    public Consulta closeConsulta(Long id) {
        Consulta consulta = this.consultaById(id);
        consulta.setConsultaStatusEnum(ConsultaStatusEnum.CLOSED);
        return consultaRepository.save(consulta);
    }


}
