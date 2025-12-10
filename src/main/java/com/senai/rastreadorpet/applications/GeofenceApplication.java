package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.dto.GeofenceUpdateDTO;
import com.senai.rastreadorpet.entities.Geofence;
import com.senai.rastreadorpet.models.GeofenceModel;
import com.senai.rastreadorpet.repositories.GeofenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.senai.rastreadorpet.mappers.GeofenceMapper.GEOFENCE_MAPPER;

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

    public Geofence update(int id, GeofenceUpdateDTO geofenceUpdateDTO) {
        return geofenceRepository.findById(id)
                .map(existingModel -> {
                    Geofence existingGeofence = GEOFENCE_MAPPER.fromModel(existingModel);

                    GEOFENCE_MAPPER.updateGeofenceFromDto(geofenceUpdateDTO, existingGeofence);

                    GeofenceModel updatedModel = geofenceRepository.save(GEOFENCE_MAPPER.toModel(existingGeofence));

                    return GEOFENCE_MAPPER.fromModel(updatedModel);
                })
                .orElse(null);
    }

    public void delete(int id) {
        geofenceRepository.deleteById(id);
    }

    public Geofence findViolatedGeofence(int deviceId, double latitude, double longitude) {

        List<Geofence> relevantGeofences = geofenceRepository.findByDeviceId(deviceId)
                .stream()
                .map(Geofence::fromModel)
                .toList();

        if (relevantGeofences.isEmpty()) {
            return null;
        }

        for (Geofence geofence : relevantGeofences) {
            double distance = calculateDistance(latitude, longitude, geofence.getLatitude(), geofence.getLongitude());

            if (distance <= geofence.getRadius()) {
                return null;
            }
        }

        return relevantGeofences.getFirst();
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}