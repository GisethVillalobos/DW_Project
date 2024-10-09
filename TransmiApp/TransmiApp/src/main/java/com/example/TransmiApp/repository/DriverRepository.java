package com.example.TransmiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Driver;
    
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    
}
