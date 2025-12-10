package com.senai.rastreadorpet.mappers;

import com.senai.rastreadorpet.dto.GeofenceDTO;
import com.senai.rastreadorpet.dto.GeofenceUpdateDTO;
import com.senai.rastreadorpet.entities.Geofence;
import com.senai.rastreadorpet.models.GeofenceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeofenceMapper {
    GeofenceMapper GEOFENCE_MAPPER = Mappers.getMapper(GeofenceMapper.class);

    Geofence toEntity(GeofenceDTO geofenceDTO);

    GeofenceDTO toDTO(Geofence geofence);

    GeofenceModel toModel(Geofence geofence);

    Geofence fromModel(GeofenceModel model);

    @Mapping(target = "id", ignore = true)
    void updateGeofenceFromDto(GeofenceUpdateDTO dto, @MappingTarget Geofence existingGeofence);
}
