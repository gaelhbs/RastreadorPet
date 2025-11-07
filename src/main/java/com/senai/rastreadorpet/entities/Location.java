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
    private LocalDateTime dateTime;
    private BigDecimal batteryLevel;
    private int deviceId;

    public LocationModel toModel() {
        return new LocationModel(
                this.id,
                this.latitude,
                this.longitude,
                this.dateTime,
                this.batteryLevel,
                this.deviceId,
                null
        );
    }

    public static Location fromModel(LocationModel model) {
        return new Location(
                model.getId(),
                model.getLatitude(),
                model.getLongitude(),
                model.getDateTime(),
                model.getBatteryLevel(),
                model.getDeviceId()
        );
    }
}
