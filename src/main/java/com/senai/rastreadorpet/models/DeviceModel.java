package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devices")
public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

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
}