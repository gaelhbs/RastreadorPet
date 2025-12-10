package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.applications.HistoryBatchApplication;
import com.senai.rastreadorpet.models.LocationHistoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryBatchApplication historyBatchApplication;

    @GetMapping("/{deviceId}")
    public List<LocationHistoryModel> getHistoricalData(
            @PathVariable int deviceId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        return historyBatchApplication.getHistoricalData(deviceId, start, end);
    }
}
