package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class DeviceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
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

    public DeviceModel() {
    }

    public DeviceModel(Integer id, String deviceCodeIdentifier, String deviceModel,
                       String deviceStatus, String deviceSecretHash,
                       LocalDateTime deviceLastCommunication) {
        this.id = id;
        this.deviceCodeIdentifier = deviceCodeIdentifier;
        this.deviceModel = deviceModel;
        this.deviceStatus = deviceStatus;
        this.deviceSecretHash = deviceSecretHash;
        this.deviceLastCommunication = deviceLastCommunication;
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getDeviceCodeIdentifier() {
        return deviceCodeIdentifier;

    }

    public void setDeviceCodeIdentifier(String deviceCodeIdentifier) {
        this.deviceCodeIdentifier = deviceCodeIdentifier;

    }

    public String getDeviceModel() {
        return deviceModel;

    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;

    }

    public String getDeviceStatus() {
        return deviceStatus;

    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;

    }

    public String getDeviceSecretHash() {
        return deviceSecretHash;

    }

    public void setDeviceSecretHash(String deviceSecretHash) {
        this.deviceSecretHash = deviceSecretHash;

    }

    public LocalDateTime getDeviceLastCommunication() {
        return deviceLastCommunication;

    }
    public void setDeviceLastCommunication(LocalDateTime deviceLastCommunication) {
        this.deviceLastCommunication = deviceLastCommunication;

    }


}