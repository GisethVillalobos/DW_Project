package com.example.TransmiApp.repository;

import com.example.TransmiApp.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    
@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    
}
