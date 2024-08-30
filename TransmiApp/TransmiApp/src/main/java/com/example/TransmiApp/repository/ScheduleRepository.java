package com.example.TransmiApp.repository;

import com.example.TransmiApp.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    
}
