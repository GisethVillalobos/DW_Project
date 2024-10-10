package com.example.TransmiApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransmiApp.model.Route;
import com.example.TransmiApp.service.RouteService;

@RestController
@RequestMapping("/api/route")
@CrossOrigin(origins = "http://localhost:4200")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Route createRoute(@RequestBody Route route) {
        return routeService.createRoute(route);
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Route> findAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/read/{idRoute}")
    @ResponseStatus(value = HttpStatus.OK)
    public Route findById(@PathVariable Long idRoute) {
        return routeService.getRouteById(idRoute);
    }

    @PutMapping("/update/{idRoute}")
    @ResponseStatus(value = HttpStatus.OK)
    public Route updateRoute(@PathVariable Long idRoute, @RequestBody Route route) {
        return routeService.updateRoute(idRoute, route);
    }

    @DeleteMapping("/delete/{idRoute}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteRoute(@PathVariable Long idRoute) {
        routeService.deleteRoute(idRoute);
    }
}
