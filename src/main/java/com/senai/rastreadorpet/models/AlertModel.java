package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "alerts")
public class AlertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "alert_name", nullable = false)
    private TypeAlertEnum typeAlert;

    @Column(name = "alert_dateTime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "alert_alertRead", nullable = false)
    private Boolean alertRead;

    @Column(name = "alert_message", nullable = false)
    private String message;

    @Column(name = "geofence_id")
    private int geofenceId;

    @ManyToOne
    @JoinColumn(name = "geofence_id", referencedColumnName = "id", insertable = false, updatable = false)
    private GeofenceModel geofence;

}
