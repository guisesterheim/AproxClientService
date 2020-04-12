package com.aprox.clientservice.com.aprox.clientservice.service;

import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("clientService")
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @PostConstruct
    private void initialize() {
        // Runs after any constructor is called
        System.out.println("Called after the constructors");
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
