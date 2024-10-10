package com.example.TransmiApp.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="driver_table")
public class Driver {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDriver;

    private String name;
    private String identification;
    private String phone;
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "driver")
    private Set<Assignment> assignments;

    public Driver(String name, String identification, String phone, String address, Set<Assignment> assignments) {
        this.name = name;
        this.identification = identification;
        this.phone = phone;
        this.address = address;
        this.assignments = assignments;
    }

    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }
    
}

