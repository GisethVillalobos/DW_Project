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
@Table(name="route_table")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoute;

    private String code;
    private List<String> stations;

    @JsonManagedReference
    @OneToMany(mappedBy = "route")
    private Set<Assignment> assignments;

    public Route(String code, List<String> stations, Set<Assignment> assignments) {
        this.code = code;
        this.stations = stations;
        this.assignments = assignments;
    }

    public Long getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Long idRoute) {
        this.idRoute = idRoute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }



}
