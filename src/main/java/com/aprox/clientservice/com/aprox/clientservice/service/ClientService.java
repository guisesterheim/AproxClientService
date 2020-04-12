package com.aprox.clientservice.com.aprox.clientservice.service;

import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository clientRepository = new ClientRepository();

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
