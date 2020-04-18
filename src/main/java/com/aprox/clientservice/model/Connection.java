package com.aprox.clientservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name="connection")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Environment environmentA;

    @OneToOne(cascade = CascadeType.ALL)
    private Environment environmentB;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Environment getEnvironmentA() {
        return environmentA;
    }

    public void setEnvironmentA(Environment environmentA) {
        this.environmentA = environmentA;
    }

    public Environment getEnvironmentB() {
        return environmentB;
    }

    public void setEnvironmentB(Environment environmentB) {
        this.environmentB = environmentB;
    }
}