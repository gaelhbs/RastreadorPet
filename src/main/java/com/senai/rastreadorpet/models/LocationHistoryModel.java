package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "location_history")
public class LocationHistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "location_latitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "location_longitude", nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "location_date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "location_battery_level", precision = 5, scale = 2)
    private BigDecimal batteryLevel;

    @Column(name = "device_id")
    private int deviceId;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id", insertable = false, updatable = false)
    private DeviceModel device;
}
