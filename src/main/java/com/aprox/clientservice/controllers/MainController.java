package com.aprox.clientservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MainController {

    public ResponseEntity ok(Object obj){
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity ok(List<?> obj){
        return ResponseEntity.ok(obj);
    }
}
