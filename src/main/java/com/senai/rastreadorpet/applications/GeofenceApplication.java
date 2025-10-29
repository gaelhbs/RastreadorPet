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


    // Converte Entity -> Model
    private GeofenceModel toModel(Geofence entity) {
        GeofenceModel model = new GeofenceModel();
        model.setId(entity.getId());
        model.setActive(entity.isActive());
        model.setName(entity.getName());
        model.setArea(entity.getArea());
        model.setUserId(entity.getUserId());
        model.setAlerts(entity.getAlerts());
        return model;
    }

    // Converte Model -> Entity
    private Geofence toEntity(GeofenceModel model) {
        Geofence entity = new Geofence();
        entity.setId(model.getId());
        entity.setActive(model.isActive());
        entity.setName(model.getName());
        entity.setArea(model.getArea());
        entity.setUserId(model.getUserId());
        entity.setAlerts(model.getAlerts());
        return entity;
    }

    public Geofence create(Geofence entity) {
        GeofenceModel saved = geofenceRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Geofence> findAll() {
        return geofenceRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Geofence findById(int id) {
        return geofenceRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Geofence update(int id, Geofence entity) {
        if (!geofenceRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        GeofenceModel updated = geofenceRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        geofenceRepository.deleteById(id);
    }
}