package com.senai.rastreadorpet.models.enums;

import com.senai.rastreadorpet.models.AlertModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeAlertEnum {
        ENTRADA_GEOFENCE,
        SAIDA_GEOFENCE,
        BATERIA_BAIXA
}
