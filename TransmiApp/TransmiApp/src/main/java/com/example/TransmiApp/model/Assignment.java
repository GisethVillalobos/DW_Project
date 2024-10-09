package com.example.TransmiApp.model;

import java.util.*;
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
@Table(name="assignment_table")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssignment;

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

    public Assignment(Driver driver, Bus bus, Route route, Schedule schedule) {
        this.driver = driver;
        this.bus = bus;
        this.route = route;
        this.schedule = schedule;
    }

}
