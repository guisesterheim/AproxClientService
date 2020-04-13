package com.aprox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }

    /*
    spring.datasource.url=jdbc:mysql://localhost:3306/client_database
    spring.datasource.username=root
    spring.datasource.password=clientDatabase421!

    APROX_CLIENT_DATABASE_URL=jdbc:mysql://localhost:3306/client_database;APROX_CLIENT_DATABASE_USER=root;APROX_CLIENT_DATABASE_PASSWORD=clientDatabase421!

    spring.datasource.url=${APROX_CLIENT_DATABASE_URL}
    spring.datasource.username=${APROX_CLIENT_DATABASE_USER}
    spring.datasource.password=${APROX_CLIENT_DATABASE_PASSWORD}

    */
}