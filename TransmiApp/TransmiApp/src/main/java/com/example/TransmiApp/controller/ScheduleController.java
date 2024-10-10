package com.example.TransmiApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransmiApp.model.Schedule;
import com.example.TransmiApp.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Schedule> findAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/read/{idSchedule}")
    @ResponseStatus(value = HttpStatus.OK)
    public Schedule findById(@PathVariable Long idSchedule) {
        return scheduleService.getScheduleById(idSchedule);
    }

    @PutMapping("/update/{idSchedule}")
    @ResponseStatus(value = HttpStatus.OK)
    public Schedule updateSchedule(@PathVariable Long idSchedule, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(idSchedule, schedule);
    }

    @DeleteMapping("/delete/{idSchedule}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteSchedule(@PathVariable Long idSchedule) {
        scheduleService.deleteSchedule(idSchedule);
    }
}
