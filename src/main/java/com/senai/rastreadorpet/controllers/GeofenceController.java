package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.dto.GeofenceDTO;
import com.senai.rastreadorpet.dto.GeofenceUpdateDTO;
import com.senai.rastreadorpet.entities.Geofence;
import com.senai.rastreadorpet.facade.GeofenceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geofences")
@RequiredArgsConstructor
public class GeofenceController {

    private final GeofenceFacade geofenceFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Geofence> getAllGeofences() {
        List<Geofence> geofences = geofenceFacade.findAll();
        return geofenceFacade.findAll();
    }

    @PostMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Geofence createGeofence(@PathVariable int deviceId, @RequestBody GeofenceDTO geofenceDTO) {
        return geofenceFacade.save(deviceId,geofenceDTO);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Geofence getGeofenceById(@PathVariable int id) {
        return geofenceFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Geofence updateGeofence(@PathVariable int id, @RequestBody GeofenceUpdateDTO geofenceUpdateDTO) {
        return geofenceFacade.update(id, geofenceUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGeofence(@PathVariable int id) {
        geofenceFacade.delete(id);
    }
}
