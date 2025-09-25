package com.senai.rastreadorpet.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class GeofenceEntity {
    private int id;
    private String name;
    private float area;
    private boolean active;
}
