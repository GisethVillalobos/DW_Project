package com.example.TransmiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Bus;
    
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    
}
