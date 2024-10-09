package com.example.TransmiApp.service;

import java.util.List;
import java.util.Optional;

import com.example.TransmiApp.model.Route;

public interface RouteService {
    List<Route> getAllRoutes();
    Optional<Route> getRouteById(Long idRoute);
    Route createRoute(Route route);
    Optional<Route> updateRoute(Long idRoute, Route route);
    void deleteRoute(Long idRoute);
}
