package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.AlertModel;
import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    private int id;
    private TypeAlertEnum typeAlert;
    private LocalDateTime dateTime;
    private Boolean alertRead;
    private int geofenceId;

    public AlertModel toModel() {
            return new AlertModel(
                    this.id,
                    this.typeAlert,
                    this.dateTime,
                    this.alertRead,
                    this.geofenceId,
                    null
            );
    }

    public static Alert fromModel(AlertModel model) {
        return new Alert(
                model.getId(),
                model.getTypeAlert(),
                model.getDateTime(),
                model.getAlertRead(),
                model.getGeofenceId()
        );
    }

}