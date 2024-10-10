package com.example.TransmiApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TransmiApp.model.Schedule;
    
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    
}
