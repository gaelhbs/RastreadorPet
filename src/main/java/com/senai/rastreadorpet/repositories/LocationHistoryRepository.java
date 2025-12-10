package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.LocationHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LocationHistoryRepository extends JpaRepository<LocationHistoryModel, Integer> {
    List<LocationHistoryModel> findAllByDeviceIdAndDateTimeBetween(int deviceId, LocalDateTime startDate, LocalDateTime endDate);
}
