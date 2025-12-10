package com.senai.rastreadorpet.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LocationHistoryPointDTO {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Long timestamp;
}
