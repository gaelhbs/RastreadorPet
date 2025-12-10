package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.AlertModel;
import com.senai.rastreadorpet.models.GeofenceModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geofence {
    private int id;
    private String name;
    private float area;
    private boolean active;
    private int userId;
    private double latitude;
    private double longitude;
    private double radius;
    private int deviceId;
    private List<AlertModel> alerts = new ArrayList<>();


    public GeofenceModel toModel() {
        return new GeofenceModel(
                this.id,
                this.name,
                this.area,
                this.active,
                this.latitude,
                this.longitude,
                this.radius,
                this.deviceId,
                null,
                this.alerts
        );
    }

    public static Geofence fromModel(GeofenceModel model) {
        return new Geofence(
                model.getId(),
                model.getName(),
                model.getArea(),
                model.isActive(),
                0,
                model.getLatitude(),
                model.getLongitude(),
                model.getRadius(),
                model.getDeviceId(),
                model.getAlerts()
        );
    }
}
