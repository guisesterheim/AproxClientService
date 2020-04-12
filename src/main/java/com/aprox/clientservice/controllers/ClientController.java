package com.aprox.clientservice.controllers;

import com.aprox.clientservice.com.aprox.clientservice.service.ClientService;
import com.aprox.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController extends MainController {

    @Autowired
    private ClientService clientService;

    public ClientController(HttpStatus status) {
        super(status);
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
        return ok(clientService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> create(@RequestBody final Client client){
        return ok(clientService.createClient(client));
    }
}
