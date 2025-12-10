package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.dto.LocationUpdateDTO;
import com.senai.rastreadorpet.entities.Alert;
import com.senai.rastreadorpet.entities.Geofence;
import com.senai.rastreadorpet.entities.Location;
import com.senai.rastreadorpet.models.LocationModel;
import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import com.senai.rastreadorpet.repositories.AlertRepository;
import com.senai.rastreadorpet.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.senai.rastreadorpet.mappers.LocationMapper.LOCATION_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationApplication {

    private final LocationRepository locationRepository;
    private final AlertRepository alertRepository;
    private final GeofenceApplication geofenceApplication;

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

    public void checkLocationAndGenerateAlert(int deviceId, double latitude, double longitude) {

        Geofence violatedGeofence = geofenceApplication.findViolatedGeofence(deviceId,latitude, longitude);

            if (violatedGeofence != null) {
                Alert alert = Alert.builder()
                        .message("Location is outside the geofence radius." + " Coordinates: " + latitude + ", " + longitude)
                        .alertRead(false)
                        .typeAlert(TypeAlertEnum.GEOFENCE_EXIT)
                        .dateTime(LocalDateTime.now())
                        .geofenceId(violatedGeofence.getId())
                        .build();

                alertRepository.save(alert.toModel());
                log.warn(alert.getMessage());
            }
    }
}
