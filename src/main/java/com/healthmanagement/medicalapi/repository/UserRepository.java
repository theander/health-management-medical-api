package com.healthmanagement.medicalapi.repository;

import com.healthmanagement.medicalapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
