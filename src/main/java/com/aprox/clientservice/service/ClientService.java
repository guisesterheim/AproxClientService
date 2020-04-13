package com.aprox.clientservice.service;

import com.aprox.clientservice.model.Client;
import com.aprox.clientservice.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("ClientService")
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client getOne(Long id){ return clientRepository.getOne(id);}

    public Client createClient(Client client){ return clientRepository.saveAndFlush(client); }

    public Client updateClient(Long id, Client client){
        Client existingClient = this.getOne(id);
        BeanUtils.copyProperties(client, existingClient, "session_id");
        return clientRepository.saveAndFlush(client);
    }

    public void deleteClient(Long id){ clientRepository.deleteById(id);}
}
