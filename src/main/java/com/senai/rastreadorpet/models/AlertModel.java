package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alerts")
public class AlertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TypeAlertEnum typeAlert;
    private LocalDateTime dateTime;
    private Boolean alertRead;
}