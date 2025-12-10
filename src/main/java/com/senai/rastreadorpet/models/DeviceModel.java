package com.senai.rastreadorpet.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devices")
public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "device_code_identifier", nullable = false, length = 100, unique = true)
    private String deviceCodeIdentifier;

    @Column(name = "device_model", length = 100)
    private String deviceModel;

    @Column(name = "device_status", length = 50)
    private String deviceStatus;

    @Column(name = "device_secret_hash", length = 255, nullable = false)
    private String deviceSecretHash;

    @Column(name = "device_last_communication")
    private LocalDateTime deviceLastCommunication;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",  insertable = false, updatable = false)
    private UserModel user;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<LocationModel> locations = new ArrayList<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<GeofenceModel> geofences = new ArrayList<>();
}