package com.senai.rastreadorpet.dto;

import lombok.Data;

@Data
public class GeofenceDTO {
    private String name;
    private double latitude;
    private double longitude;
    private double radius;
}
