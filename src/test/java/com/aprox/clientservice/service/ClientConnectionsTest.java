package com.aprox.clientservice.service;

import com.aprox.clientservice.model.Connection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientConnectionsTest {

    @Autowired
    private EnvironmentService environmentService;

    @Test
    @DisplayName("return existing connections for this client")
    void whenThereAreNone(){
        List<Connection> connections = environmentService.findAll();
    }
}