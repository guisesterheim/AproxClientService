package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Consumption, Long> {

}
