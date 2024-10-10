package com.example.TransmiApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Route;
    
@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
    
}