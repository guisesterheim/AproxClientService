package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Client;

import java.util.ArrayList;
import java.util.List;

// Transform this into JPA
public class ClientRepository {

    public List<Client> findAll(){
        List<Client> clients = new ArrayList<Client>();

        Client client = new Client();
        client.setRepresentativeFirstName("Guilherme");
        client.setRepresentativeLastName("Sesterheim");

        clients.add(client);

        return clients;
    }
}
