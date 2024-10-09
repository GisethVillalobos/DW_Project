package com.example.TransmiApp.service.impl;

import com.example.TransmiApp.model.Schedule;
import com.example.TransmiApp.repository.ScheduleRepository;
import com.example.TransmiApp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<Schedule> getScheduleById(Long idSchedule) {
        return scheduleRepository.findById(idSchedule);
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Optional<Schedule> updateSchedule(Long idSchedule, Schedule schedule) {
        if (scheduleRepository.existsById(idSchedule)) {
            schedule.setIdSchedule(idSchedule);
            return Optional.of(scheduleRepository.save(schedule));
        }
        return Optional.empty();
    }

    @Override
    public void deleteSchedule(Long idSchedule) {
        if (scheduleRepository.existsById(idSchedule)) {
            scheduleRepository.deleteById(idSchedule);
        }
    }
}
