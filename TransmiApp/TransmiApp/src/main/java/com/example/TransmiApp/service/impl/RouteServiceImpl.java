package com.example.TransmiApp.service.impl;

import com.example.TransmiApp.model.Route;
import com.example.TransmiApp.repository.RouteRepository;
import com.example.TransmiApp.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Optional<Route> getRouteById(Long idRoute) {
        return routeRepository.findById(idRoute);
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Optional<Route> updateRoute(Long idRoute, Route route) {
        if (routeRepository.existsById(idRoute)) {
            route.setIdRoute(idRoute);
            return Optional.of(routeRepository.save(route));
        }
        return Optional.empty();
    }

    @Override
    public void deleteRoute(Long idRoute) {
        if (routeRepository.existsById(idRoute)) {
            routeRepository.deleteById(idRoute);
        }
    }
}
