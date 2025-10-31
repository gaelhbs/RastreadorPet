package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

    @Column(name = "device_id")
    private int deviceId;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id",  insertable = false, updatable = false)
    private DeviceModel device;

    @OneToMany(mappedBy = "geofence", cascade = CascadeType.ALL)
    private List<AlertModel> alerts = new ArrayList<>();
}
