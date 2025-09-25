package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.LocationEntity;
import com.senai.rastreadorpet.facade.LocationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class LocationController {
    private final LocationFacade locationFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LocationEntity> getAllDevice() {
        List<LocationEntity> pets = locationFacade.findAll();
        return locationFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationEntity createUser(@RequestBody LocationEntity location) {
        return locationFacade.create(location);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationEntity getUserById(@PathVariable int id) {
        return locationFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationEntity updateUser(@PathVariable int id, @RequestBody LocationEntity location) {
        return locationFacade.update(id, location);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        locationFacade.delete(id);
    }
}
