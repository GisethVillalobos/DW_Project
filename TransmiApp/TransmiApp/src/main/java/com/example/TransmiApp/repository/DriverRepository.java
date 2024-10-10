package com.example.TransmiApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Driver;
    
@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {
    
}
