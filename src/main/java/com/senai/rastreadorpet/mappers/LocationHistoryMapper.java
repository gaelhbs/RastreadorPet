package com.senai.rastreadorpet.mappers;

import com.senai.rastreadorpet.dto.LocationHistoryPointDTO;
import com.senai.rastreadorpet.mappers.utils.MappingUtilsMapper;
import com.senai.rastreadorpet.models.LocationHistoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MappingUtilsMapper.class})
public interface LocationHistoryMapper {

    LocationHistoryMapper LOCATION_HISTORY_MAPPER = Mappers.getMapper(LocationHistoryMapper.class);

    @Mapping(source = "timestamp", target = "dateTime")
    LocationHistoryModel toEntity(LocationHistoryPointDTO dto);

    List<LocationHistoryModel> toEntityList(List<LocationHistoryPointDTO> dtoList);

    default LocationHistoryModel toEntityWithDeviceId(LocationHistoryPointDTO dto, int deviceId) {
        LocationHistoryModel model = toEntity(dto);
        model.setDeviceId(deviceId);
        return model;
    }
}
