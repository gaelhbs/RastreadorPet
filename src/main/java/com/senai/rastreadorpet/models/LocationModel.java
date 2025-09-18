package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(precision = 5, scale = 2)
    private BigDecimal batteryLevel;

    public LocationModel() {
    }

    public LocationModel(Integer id, BigDecimal latitude, BigDecimal longitude, LocalDateTime dateTime, BigDecimal batteryLevel) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = dateTime;
        this.batteryLevel = batteryLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(BigDecimal batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public String toString() {
        return "LocationModel{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dateTime=" + dateTime +
                ", batteryLevel=" + batteryLevel +
                '}';
    }

}
