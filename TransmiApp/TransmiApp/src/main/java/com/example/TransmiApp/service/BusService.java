package com.example.TransmiApp.service;

import java.util.List;

import com.example.TransmiApp.model.Bus;

public interface BusService {
    List<Bus> getAllBuses();
    Bus getBusById(Long idBus);
    Bus createBus(Bus bus);
    Bus updateBus(Long idBus, Bus bus);
    void deleteBus(Long idBus);
}
