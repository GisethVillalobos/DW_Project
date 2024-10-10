package com.example.TransmiApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TransmiApp.model.Route;
import com.example.TransmiApp.repository.RouteRepository;
import com.example.TransmiApp.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return (List<Route>) routeRepository.findAll();
    }

    @Override
    public Route getRouteById(Long idRoute) {
        return routeRepository.findById(idRoute).orElse(null);
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Long idRoute, Route route) {
        Route existingRoute = routeRepository.findById(idRoute).orElseThrow();

        existingRoute.setCode(route.getCode());
        existingRoute.setStations(route.getStations());
        existingRoute.setAssignments(route.getAssignments());
        
        return routeRepository.save(existingRoute);
    }

    @Override
    public void deleteRoute(Long idRoute) {
        if (routeRepository.existsById(idRoute)) {
            routeRepository.deleteById(idRoute);
        }
    }
}
