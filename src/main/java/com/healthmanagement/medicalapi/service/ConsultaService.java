package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Consulta;
import com.healthmanagement.medicalapi.model.ConsultaStatusEnum;
import com.healthmanagement.medicalapi.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.util.*;
import java.util.stream.Stream;

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

        if (medico.isEmpty()) {
            return consultaRepository.findAllByUsernameEqualsAndConsultaStatusEnumEquals(username, ConsultaStatusEnum.valueOf(status));
        }
        return consultaRepository.findAllByMedicoEqualsAndConsultaStatusEnumEquals(medico, ConsultaStatusEnum.valueOf(status));

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

    public Map<Integer,Integer> countConsultaByMonth() {
        Map<Integer,Integer> map = new HashMap<>();
        Stream<Month> stream = Arrays.stream(Month.values());
        stream.forEach(month -> {
            int o = consultaRepository.countForMonth(month.getValue());
            map.put(month.getValue(),o);
        });
        return map;
    }
}
