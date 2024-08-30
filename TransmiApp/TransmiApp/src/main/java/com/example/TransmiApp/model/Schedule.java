package com.example.TransmiApp.model;

import java.util.*;
import jakarta.persistence.*;
import java.sql.Time;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;
    private List<String> days;
    private Time timeStart;
    private Time timeEnd;

    @OneToMany(mappedBy = "schedule")
    private Set<Assignment> assignments;

    
}
