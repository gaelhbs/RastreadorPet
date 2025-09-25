package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.GeofenceEntity;
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
    private GeofenceModel toModel(GeofenceEntity geofenceEntity) {
        GeofenceModel geofenceModel = new GeofenceModel();
        geofenceModel.setId(geofenceEntity.getId());
        geofenceModel.setActive(geofenceEntity.isActive());
        geofenceModel.setName(geofenceEntity.getName());
        geofenceModel.setArea(geofenceEntity.getArea());

        return geofenceModel;
    }

    // Converte Model -> Entity
    private GeofenceEntity toEntity(GeofenceModel geofenceModel) {
        GeofenceEntity geofenceEntity = new GeofenceEntity();
        geofenceEntity.setId(geofenceModel.getId());
        geofenceEntity.setActive(geofenceModel.isActive());
        geofenceEntity.setName(geofenceModel.getName());
        geofenceEntity.setArea(geofenceModel.getArea());
        return geofenceEntity;
    }

    public GeofenceEntity create(GeofenceEntity geofenceEntity) {
        GeofenceModel saved = geofenceRepository.save(toModel(geofenceEntity));
        return toEntity(saved);
    }

    public List<GeofenceEntity> findAll() {
        return geofenceRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public GeofenceEntity findById(int id) {
        return geofenceRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public GeofenceEntity update(int id, GeofenceEntity geofenceEntity) {
        if (!geofenceRepository.existsById(id)) {
            return null;
        }
        geofenceEntity.setId(id);
        GeofenceModel updated = geofenceRepository.save(toModel(geofenceEntity));
        return toEntity(updated);
    }

    public void delete(int id) {
        geofenceRepository.deleteById(id);
    }
}