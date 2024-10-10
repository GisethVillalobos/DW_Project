package com.example.TransmiApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Bus;
    
@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {
    
}
