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

import com.example.TransmiApp.model.Driver;
import com.example.TransmiApp.service.DriverService;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/read/{idDriver}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long idDriver) {
        Optional<Driver> driver = driverService.getDriverById(idDriver);
        return driver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

    @PutMapping("/update/{idDriver}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long idDriver, @RequestBody Driver driver) {
        Optional<Driver> updatedDriver = driverService.updateDriver(idDriver, driver);
        return updatedDriver.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idDriver}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long idDriver) {
        driverService.deleteDriver(idDriver);
        return ResponseEntity.noContent().build();
    }
}
