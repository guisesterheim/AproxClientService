package com.aprox.clientservice.controllers;

import com.aprox.clientservice.service.ClientService;
import com.aprox.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController extends MainController {

    @Value("${app.version}")
    private String appVersion;

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity<List<Client>> list() {
        return ok(clientService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id){
        return ok(clientService.getOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> create(@RequestBody Client client){
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
