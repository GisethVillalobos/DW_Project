package com.example.TransmiApp.service;

import java.util.List;

import com.example.TransmiApp.model.Route;

public interface RouteService {
    List<Route> getAllRoutes();
    Route getRouteById(Long idRoute);
    Route createRoute(Route route);
    Route updateRoute(Long idRoute, Route route);
    void deleteRoute(Long idRoute);
}
