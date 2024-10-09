package com.example.TransmiApp.service.impl;

import com.example.TransmiApp.model.Bus;
import com.example.TransmiApp.repository.BusRepository;
import com.example.TransmiApp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Optional<Bus> getBusById(Long idBus) {
        return busRepository.findById(idBus);
    }

    @Override
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Optional<Bus> updateBus(Long idBus, Bus bus) {
        if (busRepository.existsById(idBus)) {
            bus.setIdBus(idBus);
            return Optional.of(busRepository.save(bus));
        }
        return Optional.empty();
    }

    @Override
    public void deleteBus(Long idBus) {
        if (busRepository.existsById(idBus)) {
            busRepository.deleteById(idBus);
        }
    }
}
