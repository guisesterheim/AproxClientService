package com.aprox.clientservice.controllers;

import com.aprox.clientservice.service.ClientService;
import com.aprox.clientservice.model.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController extends MainController {

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
