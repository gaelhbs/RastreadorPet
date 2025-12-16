package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.LocationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private int id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime locationDateTime;
    private BigDecimal batteryLevel;
    private int deviceId;
    private String zoneName;

    public LocationModel toModel() {
        return new LocationModel(
                this.id,
                this.latitude,
                this.longitude,
                this.locationDateTime,
                this.batteryLevel,
                this.deviceId,
                this.zoneName,
                null
        );
    }

    public static Location fromModel(LocationModel model) {
        return new Location(
                model.getId(),
                model.getLatitude(),
                model.getLongitude(),
                model.getLocationDateTime(),
                model.getBatteryLevel(),
                model.getDeviceId(),
                model.getZoneName()
        );
    }

    public void updateData(BigDecimal latitude, BigDecimal longitude, LocalDateTime dateTime, BigDecimal batteryLevel, int deviceId) {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException("Latitude e longitude não podem ser nulas");
        }
        if (dateTime == null) {
            throw new IllegalArgumentException("Data/hora não pode ser nula");
        }
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDateTime = dateTime;
        this.batteryLevel = batteryLevel;
        this.deviceId = deviceId;
    }
}
