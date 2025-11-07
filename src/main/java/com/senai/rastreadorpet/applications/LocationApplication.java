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

    public Location create(Location entity) {
        LocationModel saved = locationRepository.save(entity.toModel());
        return Location.fromModel(saved);
    }

    public List<Location> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(Location::fromModel)
                .collect(Collectors.toList());
    }

    public Location findById(int id) {
        return locationRepository.findById(id)
                .map(Location::fromModel)
                .orElse(null);
    }

    public Location update(int id, Location entity) {
        if (!locationRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        LocationModel updated = locationRepository.save(entity.toModel());
        return Location.fromModel(updated);
    }

    public void delete(int id) {
        locationRepository.deleteById(id);
    }

}
