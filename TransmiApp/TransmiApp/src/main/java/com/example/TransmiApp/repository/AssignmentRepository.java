package com.example.TransmiApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Assignment;
    
@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
    
}