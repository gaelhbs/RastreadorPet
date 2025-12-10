//package com.senai.rastreadorpet.applications;
//
//import com.senai.rastreadorpet.dto.LocationUpdateDTO;
//import com.senai.rastreadorpet.entities.Location;
//import com.senai.rastreadorpet.models.LocationModel;
//import com.senai.rastreadorpet.repositories.AlertRepository;
//import com.senai.rastreadorpet.repositories.LocationRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mockito;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class LocationApplicationTest {
//
//    private LocationRepository locationRepository;
//    private AlertRepository alertRepository;
//    private GeofenceApplication geofenceApplication;
//    private LocationApplication locationApplication;
//
//    @BeforeEach
//    void setup() {
//        locationRepository = Mockito.mock(LocationRepository.class);
//        alertRepository = Mockito.mock(AlertRepository.class);
//        geofenceApplication = Mockito.mock(GeofenceApplication.class);
//        locationApplication = new LocationApplication(locationRepository, alertRepository, geofenceApplication);
//    }
//
//    @Test
//    void updateShouldModifyAndSaveLocation() {
//        LocationModel existingModel = new LocationModel(1, new BigDecimal("-23.0"), new BigDecimal("-46.0"), LocalDateTime.now(), null, 0, null);
//        when(locationRepository.findById(1)).thenReturn(Optional.of(existingModel));
//
//        LocationModel savedModel = new LocationModel(1, new BigDecimal("-23.5"), new BigDecimal("-46.5"), LocalDateTime.now(), null, 0, null);
//        when(locationRepository.save(any())).thenReturn(savedModel);
//
//        LocationUpdateDTO dto = new LocationUpdateDTO();
//        dto.setLatitude(new BigDecimal("-23.5"));
//        dto.setLongitude(new BigDecimal("-46.5"));
//        dto.setDateTime(LocalDateTime.now());
//
//        Location updated = locationApplication.update(1, dto);
//
//        assertThat(updated).isNotNull();
//        assertThat(updated.getLatitude()).isEqualTo(savedModel.getLatitude());
//
//        ArgumentCaptor<LocationModel> captor = ArgumentCaptor.forClass(LocationModel.class);
//        verify(locationRepository, times(1)).save(captor.capture());
//        assertThat(captor.getValue().getLatitude()).isEqualTo(dto.getLatitude());
//    }
//}
//
