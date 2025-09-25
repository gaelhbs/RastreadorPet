package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.GeofenceApplication;
import com.senai.rastreadorpet.entities.GeofenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GeofenceFacade {
    private final GeofenceApplication geofenceApplication;

    public GeofenceEntity create(GeofenceEntity geofenceEntity) {
        return geofenceApplication.create(geofenceEntity);
    }

    public List<GeofenceEntity> findAll() {
        return geofenceApplication.findAll();
    }

    public GeofenceEntity findById(int id) {
        return geofenceApplication.findById(id);
    }

    public GeofenceEntity update(int id, GeofenceEntity geofenceEntity) {
        return geofenceApplication.update(id, geofenceEntity);
    }

    public void delete(int id) {
        geofenceApplication.delete(id);
    }
}
