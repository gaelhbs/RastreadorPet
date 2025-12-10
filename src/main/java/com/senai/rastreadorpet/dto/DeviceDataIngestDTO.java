package com.senai.rastreadorpet.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeviceDataIngestDTO {

    private int deviceId;
    private List<LocationHistoryPointDTO> historicLocations;
}
