package com.example.TransmiApp.repository;

import com.example.TransmiApp.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    
@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    
}