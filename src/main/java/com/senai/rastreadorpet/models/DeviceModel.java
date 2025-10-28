package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.senai.rastreadorpet.models.enums.ReceiptStatus;
import jakarta.persistence.*;
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
    public Integer id;

    @Column(name = "device_code_identifier", nullable = false, length = 100, unique = true)
    private String deviceCodeIdentifier;

    @Column(name = "device_model", length = 100)
    private String deviceModel;

    @Column(name = "device_status", length = 50)
    private ReceiptStatus deviceStatus;

    @Column(name = "device_secret_hash", length = 255, nullable = false)
    private String deviceSecretHash;

    @Column(name = "device_last_communication")
    private LocalDateTime deviceLastCommunication;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @JsonIdentityReference
    private List<LocationModel> locations = new ArrayList<>();
}