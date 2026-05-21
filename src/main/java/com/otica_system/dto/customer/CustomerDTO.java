package com.otica_system.dto.customer;

import java.time.LocalDate;

public class CustomerDTO {

    private Long id;
    private String name;
    private String phone;
    private String cpf;
    private LocalDate birthDate;
    private String address;
    private String neighborhood;
    private String referencePoint;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String phone, String cpf, LocalDate birthDate, String address, String neighborhood, String referencePoint) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.address = address;
        this.neighborhood = neighborhood;
        this.referencePoint = referencePoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }
}
