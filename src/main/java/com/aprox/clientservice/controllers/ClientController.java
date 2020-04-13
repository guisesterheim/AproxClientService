package com.aprox.clientservice.controllers;

import com.aprox.clientservice.service.ClientService;
import com.aprox.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController extends MainController {

    /*
    spring.datasource.url=jdbc:mysql://localhost:3306/client_database
    spring.datasource.username=root
    spring.datasource.password=clientDatabase421!

    spring.datasource.url=${APROX_CLIENT_DATABASE_URL}}
    spring.datasource.username=${APROX_CLIENT_DATABASE_USER}}
    spring.datasource.password=${APROX_CLIENT_DATABASE_PASSWORD}}

    */

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Client>> list() {
        return ok(clientService.findAll());
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> get(@PathVariable Long id){
        return ok(clientService.getOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> create(@RequestBody final Client client){
        return ok(clientService.createClient(client));
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping
    public Client update(@PathVariable Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }
}
