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

import com.example.TransmiApp.model.Bus;
import com.example.TransmiApp.service.BusService;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/all")
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/read/{idBus}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long idBus) {
        Optional<Bus> bus = busService.getBusById(idBus);
        return bus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Bus createBus(@RequestBody Bus bus) {
        return busService.createBus(bus);
    }

    @PutMapping("/update/{idBus}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long idBus, @RequestBody Bus bus) {
        Optional<Bus> updatedBus = busService.updateBus(idBus, bus);
        return updatedBus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idBus}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long idBus) {
        busService.deleteBus(idBus);
        return ResponseEntity.noContent().build();
    }
}
