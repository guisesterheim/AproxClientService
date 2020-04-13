package com.aprox.clientservice.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String CNPJ;
    private String representativeFirstName;
    private String representativeLastName;
    private String phone1;
    private String phone2;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Consumption> consumptions;

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getRepresentativeLastName() {
        return representativeLastName;
    }

    public void setRepresentativeLastName(String representativeLastName) {
        this.representativeLastName = representativeLastName;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}