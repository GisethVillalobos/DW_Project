package com.example.TransmiApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TransmiApp.model.Driver;
import com.example.TransmiApp.repository.DriverRepository;
import com.example.TransmiApp.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return (List<Driver>) driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long idDriver) {
        return driverRepository.findById(idDriver).orElse(null);
    }

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver updateDriver(Long idDriver, Driver driver) {
        Driver existingDriver = driverRepository.findById(idDriver).orElseThrow();

        existingDriver.setName(driver.getName());
        existingDriver.setIdentification(driver.getIdentification());
        existingDriver.setPhone(driver.getPhone());
        existingDriver.setAddress(driver.getAddress());
        existingDriver.setAssignments(driver.getAssignments());
        
        return driverRepository.save(existingDriver);
    }

    @Override
    public void deleteDriver(Long idDriver) {
        if (driverRepository.existsById(idDriver)) {
            driverRepository.deleteById(idDriver);
        }
    }
}
