package com.senai.rastreadorpet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntities {
    private Integer id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime dateTime;
    private BigDecimal batteryLevel;

}
