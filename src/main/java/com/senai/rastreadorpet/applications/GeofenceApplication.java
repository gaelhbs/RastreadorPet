package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Geofence;
import com.senai.rastreadorpet.model.GeofenceModel;
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
        GeofenceModel geofenceModel = new GeofenceModel();
        geofenceModel.setId(entity.getId());
        geofenceModel.setActive(entity.isActive());
        geofenceModel.setName(entity.getName());
        geofenceModel.setArea(entity.getArea());

        return geofenceModel;
    }

    // Converte Model -> Entity
    private Geofence toEntity(GeofenceModel geofenceModel) {
        Geofence geofenceEntity = new Geofence();
        geofenceEntity.setId(geofenceModel.getId());
        geofenceEntity.setActive(geofenceModel.isActive());
        geofenceEntity.setName(geofenceModel.getName());
        geofenceEntity.setArea(geofenceModel.getArea());
        return geofenceEntity;
    }
    // CREATE
    public GeofenceModel create(GeofenceModel model) {
        Geofence saved = geofenceRepository.save(toEntity(model));
        return toModel(saved);
    }

    // READ
    public List<GeofenceModel> findAll() {
        return geofenceRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
    // READ
    public GeofenceModel findById(int id) {
        return geofenceRepository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    // UPDATE
    public GeofenceModel update(int id, GeofenceModel model) {
        if (!geofenceRepository.existsById(id)) {
            return null;
        }
        model.setId(id);
        Geofence updated = geofenceRepository.save(toEntity(model));
        return toModel(updated);
    }

    public void delete(int id) {
        geofenceRepository.deleteById(id);
    }
}