package com.aprox.clientservice.service;

import com.aprox.clientservice.model.Connection;
import com.aprox.clientservice.repository.ConnectionRepository;
import com.aprox.clientservice.repository.EnvironmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private EnvironmentRepository environmentRepository;

    public List<Connection> findAllConnections(){
        return connectionRepository.findAll();
    }

    // TODO: escrever validação para que user e password não sejam nulos
    // TODO: escrever validação para que string e porta não sejam nulos
    // TODO: escrever validação para que campos não sejam maiores do que o tamanho da tabela
}
