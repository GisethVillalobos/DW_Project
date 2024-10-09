package com.example.TransmiApp.service;

import java.util.List;
import java.util.Optional;

import com.example.TransmiApp.model.Driver;

public interface DriverService {
    List<Driver> getAllDrivers();
    Optional<Driver> getDriverById(Long idDriver);
    Driver createDriver(Driver driver);
    Optional<Driver> updateDriver(Long idDriver, Driver driver);
    void deleteDriver(Long idDriver);
}
