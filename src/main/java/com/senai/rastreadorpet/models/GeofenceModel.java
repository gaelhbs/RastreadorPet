package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "geofences")
public class GeofenceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geofence_id")
    private int id;

    @Column(name = "geofence_name", nullable = false)
    private String name;

    @Column(name = "geofence_area", nullable = false)
    private float area;

    @Column(name = "geofence_active", nullable = false)
    private boolean active;
}
