package com.aprox.clientservice.repository;

import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.util.DocumentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("clientRepository")
public class ClientRepository {

    @Value("#{ T(java.lang.Math).random() * 100 }")
    private double seedNum;

    public List<Client> findAll(){
        List<Client> clients = new ArrayList<Client>();

        Client client = new Client();
        client.setRepresentativeFirstName("Guilherme");
        client.setRepresentativeLastName("Sesterheim");
        client.setSeedNum(seedNum);

        clients.add(client);

        return clients;
    }
}
