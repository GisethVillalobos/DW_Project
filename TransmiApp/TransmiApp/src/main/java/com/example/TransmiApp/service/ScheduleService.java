package com.example.TransmiApp.service;

import java.util.List;
import java.util.Optional;

import com.example.TransmiApp.model.Schedule;

public interface ScheduleService {
    List<Schedule> getAllSchedules();
    Optional<Schedule> getScheduleById(Long idSchedule);
    Schedule createSchedule(Schedule schedule);
    Optional<Schedule> updateSchedule(Long idSchedule, Schedule schedule);
    void deleteSchedule(Long idSchedule);
}
