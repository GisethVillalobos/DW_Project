package com.example.TransmiApp.service;

import java.util.List;

import com.example.TransmiApp.model.Driver;

public interface DriverService {
    List<Driver> getAllDrivers();
    Driver getDriverById(Long idDriver);
    Driver createDriver(Driver driver);
    Driver updateDriver(Long idDriver, Driver driver);
    void deleteDriver(Long idDriver);
}
