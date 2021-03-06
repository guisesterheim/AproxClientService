package com.aprox.clientservice.service;

import com.aprox.clientservice.exceptions.ClientNotFoundException;
import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.model.Consumption;
import com.aprox.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client getOne(Long id){ return clientRepository.getOne(id);}

    public Client createClient(Client client){
        addCreationDay(client);
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client){
        client.setId(id);
        return clientRepository.save(client);
    }

    public void deleteClient(Long id){ clientRepository.deleteById(id);}

    private void addCreationDay(Client client) {
        client.setDateCreation(new Date(new java.util.Date().getTime()));
    }

    public Client addConsumption(Long clientId, Integer quantity) throws ClientNotFoundException {
        return addConsumption(new Client().setId(clientId), quantity);
    }

    public Client addConsumption(Client client, Integer quantity) throws ClientNotFoundException {
        checkClientExists(client);
        checkAndSetMinimumPossibleConsumption(quantity);
        checkConsumptionsExist(client);

        Consumption consumption = new Consumption();
        consumption.setClientId(client.getId());
        consumption.setMonthYear(new Date(new java.util.Date().getTime()));
        consumption.setRequestCount(quantity);

        client.getConsumption().add(consumption);

        return updateClient(client.getId(), client);
    }

    private void checkClientExists(Client client) throws ClientNotFoundException {
        if(client == null || client.getId() == null)
            throw new ClientNotFoundException();

        client = getOne(client.getId());
    }

    private void checkConsumptionsExist(Client client) {
        if(client.getConsumption() == null)
            client.setConsumption(new ArrayList<>());
    }

    private void checkAndSetMinimumPossibleConsumption(Integer quantity) {
        if(quantity == null)
            quantity = 1;
    }
}
