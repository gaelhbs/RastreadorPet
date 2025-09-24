
package com.senai.rastreadorpet.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "geofences")
public class Geofence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geofence_id")
    private int id;

    @Column(name = "geofence_name", nullable = false)
    private String name;

    @Column(name = "geofence_area" , nullable = false)
    private float area;

    @Column(name = "geofence_active", nullable = false)
    private boolean active;
}
