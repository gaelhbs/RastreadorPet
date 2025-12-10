package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.GeofenceApplication;
import com.senai.rastreadorpet.dto.GeofenceDTO;
import com.senai.rastreadorpet.dto.GeofenceUpdateDTO;
import com.senai.rastreadorpet.entities.Geofence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.senai.rastreadorpet.mappers.GeofenceMapper.GEOFENCE_MAPPER;

@Service
@RequiredArgsConstructor
public class GeofenceFacade {

    private final GeofenceApplication geofenceApplication;

    public Geofence save(int deviceId, GeofenceDTO geofenceDTO) {
        Geofence geofence = GEOFENCE_MAPPER.toEntity(geofenceDTO);
        geofence.setDeviceId(deviceId);
        return geofenceApplication.create(geofence);
    }

    public List<Geofence> findAll() {
        return geofenceApplication.findAll();
    }

    public Geofence findById(int id) {
        return geofenceApplication.findById(id);
    }

    public Geofence update(int id, GeofenceUpdateDTO geofenceUpdateDTO) {
        return geofenceApplication.update(id, geofenceUpdateDTO);
    }

    public void delete(int id) {
        geofenceApplication.delete(id);
    }

}
