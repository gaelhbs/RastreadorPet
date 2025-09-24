package com.senai.rastreadorpet.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class GeofenceModel {
    private int id;
    private String name;
    private float area;
    private boolean active;
}
