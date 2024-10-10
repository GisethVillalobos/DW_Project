package com.example.TransmiApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TransmiApp.model.Bus;
import com.example.TransmiApp.repository.BusRepository;
import com.example.TransmiApp.service.BusService;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Bus> getAllBuses() {
        return (List<Bus>) busRepository.findAll();
    }

    @Override
    public Bus getBusById(Long idBus) {
        return busRepository.findById(idBus).orElse(null);
    }

    @Override
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(Long idBus, Bus bus) {
        Bus existingBus = busRepository.findById(idBus).orElseThrow();

        existingBus.setPlate(bus.getPlate());
        existingBus.setModel(bus.getModel());
        existingBus.setAssignments(bus.getAssignments());
        
        return busRepository.save(existingBus);
    }

    @Override
    public void deleteBus(Long idBus) {
        if (busRepository.existsById(idBus)) {
            busRepository.deleteById(idBus);
        }
    }
}
