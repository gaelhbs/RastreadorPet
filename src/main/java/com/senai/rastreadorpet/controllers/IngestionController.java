package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.applications.IngestionService;
import com.senai.rastreadorpet.dto.DeviceDataIngestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingestion")
@RequiredArgsConstructor
public class IngestionController {

    private final IngestionService ingestionService;

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void ingestData(@RequestBody DeviceDataIngestDTO data) {
        ingestionService.processIngestedData(data);
    }
}
