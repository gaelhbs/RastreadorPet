package com.senai.rastreadorpet.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceEntity {
    public Integer id;
    private String deviceCodeIdentifier;
    private String deviceModel;
    private String deviceStatus;
    private String deviceSecretHash;
    private LocalDateTime deviceLastCommunication;

}