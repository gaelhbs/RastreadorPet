
package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.GeofenceEntity;
import com.senai.rastreadorpet.facade.GeofenceFacade;
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
    public List<GeofenceEntity> getAllUsers() {
        List<GeofenceEntity> geofences = geofenceFacade.findAll();
        return geofenceFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeofenceEntity createUser(@RequestBody GeofenceEntity geofence) {
        return geofenceFacade.create(geofence);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeofenceEntity getUserById(@PathVariable int id) {
        return geofenceFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeofenceEntity updateUser(@PathVariable int id, @RequestBody GeofenceEntity geofence) {
        return geofenceFacade.update(id, geofence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        geofenceFacade.delete(id);
    }
}
