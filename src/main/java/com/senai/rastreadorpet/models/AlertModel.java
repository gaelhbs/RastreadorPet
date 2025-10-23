package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alerts")
public class AlertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private int id;

    @Column(name = "alert_name", nullable = false)
    private TypeAlertEnum typeAlert;

    @Column(name = "alert_dateTime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "alert_alertRead", nullable = false)
    private Boolean alertRead;
}
