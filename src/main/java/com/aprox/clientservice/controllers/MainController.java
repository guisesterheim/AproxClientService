package com.aprox.clientservice.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class MainController {

    // TODO: handle exceptions like suggested here: https://www.baeldung.com/global-error-handler-in-a-spring-rest-api

    public static final String COULD_NOT_FIND_DATA = "Could not find the data you were looking for";
    public static final String COULD_NOT_FIND_CLIENT = "Could not find the client you were looking for";

    public ResponseEntity ok(Object obj){
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity ok(List<?> obj){
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity error(){
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity error(String message){
        return ResponseEntity.badRequest().body(message);
    }
}
