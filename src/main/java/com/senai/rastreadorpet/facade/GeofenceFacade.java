package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.GeofenceApplication;
import com.senai.rastreadorpet.entities.Geofence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GeofenceFacade {
    private final GeofenceApplication geofenceApplication;

    public Geofence create(Geofence geofence) {
        return geofenceApplication.create(geofence);
    }

    public List<Geofence> findAll() {
        return geofenceApplication.findAll();
    }

    public Geofence findById(int id) {
        return geofenceApplication.findById(id);
    }

    public Geofence update(int id, Geofence geofence) {
        return geofenceApplication.update(id, geofence);
    }

    public void delete(int id) {
        geofenceApplication.delete(id);
    }
}
