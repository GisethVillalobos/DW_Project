package com.example.TransmiApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransmiApp.model.Schedule;
import com.example.TransmiApp.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/all")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/read/{idSchedule}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long idSchedule) {
        Optional<Schedule> schedule = scheduleService.getScheduleById(idSchedule);
        return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @PutMapping("/update/{idSchedule}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long idSchedule, @RequestBody Schedule schedule) {
        Optional<Schedule> updatedSchedule = scheduleService.updateSchedule(idSchedule, schedule);
        return updatedSchedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idSchedule}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long idSchedule) {
        scheduleService.deleteSchedule(idSchedule);
        return ResponseEntity.noContent().build();
    }
}
