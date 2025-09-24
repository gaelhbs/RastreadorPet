package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.facade.GeofenceFacade;
import com.senai.rastreadorpet.model.GeofenceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geofences")
@RequiredArgsConstructor
public class GeofenceController {

    private final GeofenceFacade geofenceFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GeofenceModel> getAllUsers() {
        List<GeofenceModel> geofences = geofenceFacade.findAll();
        return geofenceFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeofenceModel createUser(@RequestBody GeofenceModel geofence) {
        return geofenceFacade.create(geofence);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeofenceModel getUserById(@PathVariable int id) {
        return geofenceFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeofenceModel updateUser(@PathVariable int id, @RequestBody GeofenceModel geofence) {
        return geofenceFacade.update(id, geofence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        geofenceFacade.delete(id);
    }
}
