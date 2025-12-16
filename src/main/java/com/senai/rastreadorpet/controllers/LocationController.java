package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.dto.LocationUpdateDTO;
import com.senai.rastreadorpet.entities.Location;
import com.senai.rastreadorpet.facade.LocationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/locations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class LocationController {
    private final LocationFacade locationFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getAllLocation() {
        List<Location> location = locationFacade.findAll();
        return locationFacade.findAll();
    }

    @GetMapping("/today")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocationsToday() {
        return locationFacade.findLocationsToday();
    }

    @GetMapping("/this-month")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> getLocationsThisMonth() {
        return locationFacade.findLocationsThisMonth();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location createLocation(@RequestBody Location location) {
        return locationFacade.create(location);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Location getLocationById(@PathVariable int id) {
        return locationFacade.findById(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Location updateLocation(@PathVariable int id, @RequestBody LocationUpdateDTO locationUpdateDTO) {
        return locationFacade.update(id, locationUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable int id) {
        locationFacade.delete(id);
    }

    @PostMapping("/check-location/{deviceId}")
    @ResponseStatus(HttpStatus.OK)
    public void checkLocation(@PathVariable int deviceId, @RequestParam double latitude, @RequestParam double longitude) {
        locationFacade.checkLocationAndGenerateAlert(deviceId, latitude, longitude);
    }
}
