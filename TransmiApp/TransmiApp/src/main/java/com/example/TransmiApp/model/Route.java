package com.example.TransmiApp.model;

import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoute;
    private String code;
    private List<String> stations;

    @OneToMany(mappedBy = "route")
    private Set<Assignment> assignments;

    
}
