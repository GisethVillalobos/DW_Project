package com.example.TransmiApp.model;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAssignment;

    @ManyToOne
    @JoinColumn(name = "driver_idDriver")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "bus_idBus")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_idRoute")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "schedule_idSchedule")
    private Schedule schedule;
    
}
