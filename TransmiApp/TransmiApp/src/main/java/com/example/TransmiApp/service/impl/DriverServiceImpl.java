package com.example.TransmiApp.service.impl;

import com.example.TransmiApp.model.Driver;
import com.example.TransmiApp.repository.DriverRepository;
import com.example.TransmiApp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> getDriverById(Long idDriver) {
        return driverRepository.findById(idDriver);
    }

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> updateDriver(Long idDriver, Driver driver) {
        if (driverRepository.existsById(idDriver)) {
            driver.setIdDriver(idDriver);
            return Optional.of(driverRepository.save(driver));
        }
        return Optional.empty();
    }

    @Override
    public void deleteDriver(Long idDriver) {
        if (driverRepository.existsById(idDriver)) {
            driverRepository.deleteById(idDriver);
        }
    }
}
