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

import com.example.TransmiApp.model.Route;
import com.example.TransmiApp.service.RouteService;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/all")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/read/{idRoute}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long idRoute) {
        Optional<Route> route = routeService.getRouteById(idRoute);
        return route.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Route createRoute(@RequestBody Route route) {
        return routeService.createRoute(route);
    }

    @PutMapping("/update/{idRoute}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long idRoute, @RequestBody Route route) {
        Optional<Route> updatedRoute = routeService.updateRoute(idRoute, route);
        return updatedRoute.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idRoute}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long idRoute) {
        routeService.deleteRoute(idRoute);
        return ResponseEntity.noContent().build();
    }
}
