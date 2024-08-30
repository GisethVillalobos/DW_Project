package com.example.TransmiApp.repository;

import com.example.TransmiApp.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    
}