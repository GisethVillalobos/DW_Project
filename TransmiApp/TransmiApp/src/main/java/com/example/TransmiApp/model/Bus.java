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

    public Long getIdBus() {
        return idBus;
    }

    public void setIdBus(Long idBus) {
        this.idBus = idBus;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }


}
