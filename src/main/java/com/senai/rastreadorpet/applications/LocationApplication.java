package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.dto.LocationUpdateDTO;
import com.senai.rastreadorpet.entities.Location;
import com.senai.rastreadorpet.models.LocationModel;
import com.senai.rastreadorpet.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.senai.rastreadorpet.mappers.LocationMapper.LOCATION_MAPPER;

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

    public Location update(int id, LocationUpdateDTO locationUpdateDTO) {
        return locationRepository.findById(id)
                .map(existingModel -> {
                    Location existingLocation = LOCATION_MAPPER.toEntity(existingModel);

                    LOCATION_MAPPER.updateLocationFromDto(locationUpdateDTO, existingLocation);

                    LocationModel updatedModel = locationRepository.save(existingLocation.toModel());

                    return LOCATION_MAPPER.toEntity(updatedModel);
                })
                .orElse(null);
    }

    public void delete(int id) {
        locationRepository.deleteById(id);
    }

}
