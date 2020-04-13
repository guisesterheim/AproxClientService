package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ClientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

}