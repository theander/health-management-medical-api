package com.healthmanagement.medicalapi.repository;

import com.healthmanagement.medicalapi.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    List<Consulta> findAllByUsernameEquals(String username);
}
