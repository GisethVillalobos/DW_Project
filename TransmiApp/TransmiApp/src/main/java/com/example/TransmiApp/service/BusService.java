package com.example.TransmiApp.service;

import java.util.List;
import java.util.Optional;

import com.example.TransmiApp.model.Bus;

public interface BusService {
    List<Bus> getAllBuses();
    Optional<Bus> getBusById(Long idBus);
    Bus createBus(Bus bus);
    Optional<Bus> updateBus(Long idBus, Bus bus);
    void deleteBus(Long idBus);
}
