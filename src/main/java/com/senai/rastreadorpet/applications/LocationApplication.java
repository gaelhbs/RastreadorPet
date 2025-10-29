package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Location;
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
    private LocationModel toModel(Location entity) {
        LocationModel model = new LocationModel();
        model.setId(entity.getId());
        model.setLatitude(entity.getLatitude());
        model.setLongitude(entity.getLongitude());
        model.setDateTime(entity.getDateTime());
        model.setBatteryLevel(entity.getBatteryLevel());
        model.setDeviceId(entity.getDeviceId());
        return model;
    }

    // Converte Model -> Entity
    private Location toEntity(LocationModel model) {
        Location entity = new Location();
        entity.setId(model.getId());
        entity.setLatitude(model.getLatitude());
        entity.setLongitude(model.getLongitude());
        entity.setDateTime(model.getDateTime());
        entity.setBatteryLevel(model.getBatteryLevel());
        entity.setDeviceId(model.getDeviceId());
        return entity;
    }

    public Location create(Location entity) {
        LocationModel saved = locationRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Location> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Location findById(int id) {
        return locationRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Location update(int id, Location entity) {
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
