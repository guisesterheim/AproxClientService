package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {

}