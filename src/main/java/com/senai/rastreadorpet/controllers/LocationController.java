package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.LocationEntity;
import com.senai.rastreadorpet.facade.LocationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationFacade locationFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LocationEntity> getAllLocation() {
        List<LocationEntity> location = locationFacade.findAll();
        return locationFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationEntity createLocation(@RequestBody LocationEntity location) {
        return locationFacade.create(location);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationEntity getLocationById(@PathVariable int id) {
        return locationFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LocationEntity updateLocationEntity(@PathVariable int id, @RequestBody LocationEntity location) {
        return locationFacade.update(id, location);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocationEntity(@PathVariable int id) {
        locationFacade.delete(id);
    }
}
