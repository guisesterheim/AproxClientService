package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Environment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {

}