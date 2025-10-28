package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.enums.ReceiptStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    public Integer id;
    private String deviceCodeIdentifier;
    private String deviceModel;
    private ReceiptStatus deviceStatus;
    private String deviceSecretHash;
    private LocalDateTime deviceLastCommunication;

}