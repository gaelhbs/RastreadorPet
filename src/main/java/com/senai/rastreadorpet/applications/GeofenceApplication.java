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
    private GeofenceModel toModel(Geofence geofence) {
        GeofenceModel geofenceModel = new GeofenceModel();
        geofenceModel.setId(geofence.getId());
        geofenceModel.setActive(geofence.isActive());
        geofenceModel.setName(geofence.getName());
        geofenceModel.setArea(geofence.getArea());
        geofenceModel.setAlerts(geofence.getAlerts());

        return geofenceModel;
    }

    // Converte Model -> Entity
    private Geofence toEntity(GeofenceModel geofenceModel) {
        Geofence geofence = new Geofence();
        geofence.setId(geofenceModel.getId());
        geofence.setActive(geofenceModel.isActive());
        geofence.setName(geofenceModel.getName());
        geofence.setArea(geofenceModel.getArea());
        geofence.setAlerts(geofenceModel.getAlerts());
        return geofence;
    }

    public Geofence create(Geofence geofence) {
        GeofenceModel saved = geofenceRepository.save(toModel(geofence));
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

    public Geofence update(int id, Geofence geofence) {
        if (!geofenceRepository.existsById(id)) {
            return null;
        }
        geofence.setId(id);
        GeofenceModel updated = geofenceRepository.save(toModel(geofence));
        return toEntity(updated);
    }

    public void delete(int id) {
        geofenceRepository.deleteById(id);
    }
}