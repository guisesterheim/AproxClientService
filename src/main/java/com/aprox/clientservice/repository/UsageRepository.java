package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Usage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Usage, Long> {

}
