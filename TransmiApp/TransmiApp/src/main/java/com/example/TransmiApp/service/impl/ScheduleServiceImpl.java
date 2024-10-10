package com.example.TransmiApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TransmiApp.model.Schedule;
import com.example.TransmiApp.repository.ScheduleRepository;
import com.example.TransmiApp.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long idSchedule) {
        return scheduleRepository.findById(idSchedule).orElse(null);
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Long idSchedule, Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.findById(idSchedule).orElseThrow();

        existingSchedule.setDays(schedule.getDays());
        existingSchedule.setTimeStart(schedule.getTimeStart());
        existingSchedule.setTimeEnd(schedule.getTimeEnd());
        existingSchedule.setAssignments(schedule.getAssignments());
        
        return scheduleRepository.save(existingSchedule);
    }

    @Override
    public void deleteSchedule(Long idSchedule) {
        if (scheduleRepository.existsById(idSchedule)) {
            scheduleRepository.deleteById(idSchedule);
        }
    }
}
