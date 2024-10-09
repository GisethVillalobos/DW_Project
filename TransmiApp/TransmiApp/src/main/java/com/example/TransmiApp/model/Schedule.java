package com.example.TransmiApp.model;

import java.util.*;
import jakarta.persistence.*;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="schedule_table")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchedule;

    private List<String> days;
    private Time timeStart;
    private Time timeEnd;

    @OneToMany(mappedBy = "schedule")
    private Set<Assignment> assignments;

    public Schedule(List<String> days, Time timeStart, Time timeEnd, Set<Assignment> assignments) {
        this.days = days;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.assignments = assignments;
    }
}
