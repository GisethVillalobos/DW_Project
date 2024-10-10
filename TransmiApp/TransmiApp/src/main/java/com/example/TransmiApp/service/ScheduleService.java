package com.example.TransmiApp.service;

import java.util.List;

import com.example.TransmiApp.model.Schedule;

public interface ScheduleService {
    List<Schedule> getAllSchedules();
    Schedule getScheduleById(Long idSchedule);
    Schedule createSchedule(Schedule schedule);
    Schedule updateSchedule(Long idSchedule, Schedule schedule);
    void deleteSchedule(Long idSchedule);
}
