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
    @Column(name = "id")
    private int id;

    @Column(name = "geofence_name", nullable = false)
    private String name;

    @Column(name = "geofence_area", nullable = false)
    private float area;

    @Column(name = "geofence_active", nullable = false)
    private boolean active;

    @Column(name = "user_id")
    private int UserId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserModel user;
}
