package com.example.TransmiApp.model;

import java.util.*;

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

    @OneToMany(mappedBy = "driver")
    private Set<Assignment> assignments;

    public Driver(String name, String identification, String phone, String address, Set<Assignment> assignments) {
        this.name = name;
        this.identification = identification;
        this.phone = phone;
        this.address = address;
        this.assignments = assignments;
    }
    
}

