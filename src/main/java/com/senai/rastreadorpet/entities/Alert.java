package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.entities.enums.TypeAlertEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alerts")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TypeAlertEnum typeAlert;
    private LocalDateTime dateTime;
    private Boolean alertRead;
}