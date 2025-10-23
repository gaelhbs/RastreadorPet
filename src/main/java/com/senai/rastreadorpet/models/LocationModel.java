package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locations")
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer id;

    @Column(name = "location_latitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "location_longitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "location_date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "location_battery_level", precision = 5, scale = 2)
    private BigDecimal batteryLevel;

}
