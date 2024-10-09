package com.example.TransmiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Route;
    
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    
}