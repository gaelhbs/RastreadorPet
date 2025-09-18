package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "geofences")
@Getter
@Setter
@AllArgsConstructor
public class GeofenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float area;
    private boolean active;

    public GeofenceModel() {

    }
}
