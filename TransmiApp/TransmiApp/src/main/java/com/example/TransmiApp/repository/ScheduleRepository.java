package com.example.TransmiApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Schedule;
    
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    
}
