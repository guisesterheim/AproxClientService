package com.aprox.clientservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MainController extends ResponseEntity {

    public MainController(HttpStatus status) {
        super(status);
    }
}
