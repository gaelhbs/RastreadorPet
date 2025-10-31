package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.GeofenceModel;
import com.senai.rastreadorpet.models.LocationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    public int id;
    private String deviceCodeIdentifier;
    private String deviceModel;
    private String deviceStatus;
    private String deviceSecretHash;
    private LocalDateTime deviceLastCommunication;
    private int userId;
    private List<GeofenceModel> geofences = new ArrayList<>();
    private List<LocationModel> locations = new ArrayList<>();
}