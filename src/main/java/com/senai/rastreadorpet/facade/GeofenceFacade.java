package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.GeofenceApplication;
import com.senai.rastreadorpet.model.GeofenceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GeofenceFacade {
    private final GeofenceApplication geofenceApplication;

    public GeofenceModel create(GeofenceModel geofenceEntity) {
        return geofenceApplication.create(geofenceEntity);
    }

    public List<GeofenceModel> findAll() {
        return geofenceApplication.findAll();
    }

    public GeofenceModel findById(int id) {
        return geofenceApplication.findById(id);
    }

    public GeofenceModel update(int id, GeofenceModel geofenceModel) {
        return geofenceApplication.update(id, geofenceModel);
    }

    public void delete(int id) {
        geofenceApplication.delete(id);
    }
}
