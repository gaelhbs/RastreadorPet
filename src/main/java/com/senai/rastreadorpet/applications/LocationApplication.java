package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.LocationEntity;
import com.senai.rastreadorpet.models.LocationModel;
import com.senai.rastreadorpet.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationApplication {
    private final LocationRepository locationRepository;

    // Converte Entity -> Model
    private LocationModel toModel(LocationEntity entity) {
        LocationModel model = new LocationModel();
        model.setId(entity.getId());
        model.setLatitude(entity.getLatitude());
        model.setLongitude(entity.getLongitude());
        model.setDateTime(entity.getDateTime());
        model.setBatteryLevel(entity.getBatteryLevel());
        return model;
    }

    // Converte Model -> Entity
    private LocationEntity toEntity(LocationModel model) {
        LocationEntity entity = new LocationEntity();
        entity.setId(model.getId());
        entity.setLatitude(model.getLatitude());
        entity.setLongitude(model.getLongitude());
        entity.setDateTime(model.getDateTime());
        entity.setBatteryLevel(model.getBatteryLevel());
        return entity;
    }

    public LocationEntity create(LocationEntity entity) {
        LocationModel saved = locationRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<LocationEntity> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public LocationEntity findById(int id) {
        return locationRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public LocationEntity update(int id, LocationEntity entity) {
        if (!locationRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        LocationModel updated = locationRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        locationRepository.deleteById(id);
    }

}
