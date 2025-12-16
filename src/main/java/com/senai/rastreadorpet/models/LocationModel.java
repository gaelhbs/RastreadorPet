package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "locations")
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "location_latitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "location_longitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "location_date_time", nullable = true)
    private LocalDateTime locationDateTime;

    @Column(name = "location_battery_level", precision = 5, scale = 2)
    private BigDecimal batteryLevel;

    @Column(name = "location_distance")
    private float distance;

    @Column(name = "device_id")
    private int deviceId;

    @Column(name = "location_name_zone")
    private String zoneName;

    @ManyToOne
    @JoinColumn(name = "device_id",  referencedColumnName = "id", insertable = false, updatable = false)
    private DeviceModel device;
}
