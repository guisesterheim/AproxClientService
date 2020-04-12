package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.util.DocumentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
