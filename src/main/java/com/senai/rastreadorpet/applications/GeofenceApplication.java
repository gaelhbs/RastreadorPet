package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Geofence;
import com.senai.rastreadorpet.models.GeofenceModel;
import com.senai.rastreadorpet.repositories.GeofenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeofenceApplication {
    private final GeofenceRepository geofenceRepository;

    public Geofence create(Geofence entity) {
        GeofenceModel saved = geofenceRepository.save(entity.toModel());
        return Geofence.fromModel(saved);
    }

    public List<Geofence> findAll() {
        return geofenceRepository.findAll()
                .stream()
                .map(Geofence::fromModel)
                .collect(Collectors.toList());
    }

    public Geofence findById(int id) {
        return geofenceRepository.findById(id)
                .map(Geofence::fromModel)
                .orElse(null);
    }

    public Geofence update(int id, Geofence entity) {
        if (!geofenceRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        GeofenceModel updated = geofenceRepository.save(entity.toModel());
        return Geofence.fromModel(updated);
    }

    public void delete(int id) {
        geofenceRepository.deleteById(id);
    }
}