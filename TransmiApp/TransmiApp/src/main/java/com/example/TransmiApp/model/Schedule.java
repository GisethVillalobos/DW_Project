package com.example.TransmiApp.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "schedule")
    private Set<Assignment> assignments;

    public Schedule(List<String> days, Time timeStart, Time timeEnd, Set<Assignment> assignments) {
        this.days = days;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.assignments = assignments;
    }

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public Time getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }


}
