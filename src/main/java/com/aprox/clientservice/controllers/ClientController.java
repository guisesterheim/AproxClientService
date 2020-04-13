package com.aprox.clientservice.controllers;

import com.aprox.clientservice.repository.ClientRepository;
import com.aprox.clientservice.service.ClientService;
import com.aprox.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private ClientService clientService;

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

    @GetMapping
    @RequestMapping("/version")
    public Map getAppVersion(){
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }
}
