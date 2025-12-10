package com.senai.rastreadorpet.mappers;

import com.senai.rastreadorpet.dto.LocationUpdateDTO;
import com.senai.rastreadorpet.entities.Location;
import com.senai.rastreadorpet.models.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationMapper LOCATION_MAPPER = Mappers.getMapper(LocationMapper.class);

    Location toEntity(LocationUpdateDTO dto);
    LocationUpdateDTO toDTO(Location location);
    LocationModel toModel(Location location);
    Location toEntity(LocationModel model);

    @Mapping(target = "id", ignore = true)
    void updateLocationFromDto(LocationUpdateDTO dto, @MappingTarget Location existingLocation);
}
