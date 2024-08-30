package com.example.TransmiApp.model;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBus;
    private String plate;
    private String model;

    @OneToMany(mappedBy = "bus")
    private Set<Assignment> assignments;


    
}
