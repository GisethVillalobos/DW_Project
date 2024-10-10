package com.example.TransmiApp.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bus_table")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBus;

    private String plate;
    private String model;

    @JsonManagedReference
    @OneToMany(mappedBy = "bus")
    private Set<Assignment> assignments;

    public Bus(String plate, String model, Set<Assignment> assignments) {
        this.plate = plate;
        this.model = model;
        this.assignments = assignments;
    }

}
