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

import com.example.TransmiApp.model.Driver;
import com.example.TransmiApp.service.DriverService;

@RestController
@RequestMapping("/api/driver")
@CrossOrigin(origins = "http://localhost:4200")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Driver> findAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/read/{idDriver}")
    @ResponseStatus(value = HttpStatus.OK)
    public Driver findById(@PathVariable Long idDriver) {
        return driverService.getDriverById(idDriver);
    }

    @PutMapping("/update/{idDriver}")
    @ResponseStatus(value = HttpStatus.OK)
    public Driver updateDriver(@PathVariable Long idDriver, @RequestBody Driver driver) {
        return driverService.updateDriver(idDriver, driver);
    }

    @DeleteMapping("/delete/{idDriver}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDriver(@PathVariable Long idDriver) {
        driverService.deleteDriver(idDriver);
    }

}
