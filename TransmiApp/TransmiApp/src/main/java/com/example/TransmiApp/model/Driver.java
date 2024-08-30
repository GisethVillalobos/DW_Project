package com.example.TransmiApp.model;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Driver {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDriver;
    private String name;
    private String identification;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "driver")
    private Set<Assignment> assignments;
    
    
    
}

