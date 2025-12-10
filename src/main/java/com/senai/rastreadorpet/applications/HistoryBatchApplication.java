package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.models.LocationHistoryModel;
import com.senai.rastreadorpet.repositories.LocationHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryBatchApplication {

    private final LocationHistoryRepository locationHistoryRepository;

    public List<LocationHistoryModel> getHistoricalData(int deviceId, LocalDateTime start, LocalDateTime end) {
        return locationHistoryRepository.findAllByDeviceIdAndDateTimeBetween(deviceId, start, end);
    }
}
