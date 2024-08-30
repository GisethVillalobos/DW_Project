package com.example.TransmiApp.repository;

import com.example.TransmiApp.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    
@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    
}
