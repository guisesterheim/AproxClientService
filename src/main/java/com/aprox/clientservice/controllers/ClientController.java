package com.aprox.clientservice.controllers;

import com.aprox.clientservice.service.ClientService;
import com.aprox.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController extends MainController {

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity list() {
        return ok(clientService.findAll());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity get(@PathVariable Long id){
        return ok(clientService.getOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Client client){
        return ok(clientService.createClient(client));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @GetMapping
    @RequestMapping("/version")
    public String getAppVersion(){
        return "app-version:"+appVersion;
    }
}
