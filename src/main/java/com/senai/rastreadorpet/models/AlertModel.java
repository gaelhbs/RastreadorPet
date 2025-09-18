package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
@Getter
@Setter
@AllArgsConstructor

public class AlertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TypeAlertEnum typeAlert;
    private LocalDateTime dateTime;
    private Boolean alertRead;

    public AlertModel() {

    }
}