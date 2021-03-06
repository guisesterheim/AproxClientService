package com.aprox.clientservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCreation;

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnvironmentB(Environment environmentB) {
        this.environmentB = environmentB;
    }
}