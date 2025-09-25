package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.enums.TypeAlertEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertEntity {
    private int id;
    private TypeAlertEnum typeAlert;
    private LocalDateTime dateTime;
    private Boolean alertRead;
}