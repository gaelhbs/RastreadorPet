package com.senai.rastreadorpet.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LocationUpdateDTO {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime dateTime;
    private BigDecimal batteryLevel;
    private int deviceId;
}

