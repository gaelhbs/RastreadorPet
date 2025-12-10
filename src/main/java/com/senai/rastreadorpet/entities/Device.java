package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.DeviceModel;
import com.senai.rastreadorpet.models.GeofenceModel;
import com.senai.rastreadorpet.models.LocationModel;
import com.senai.rastreadorpet.models.PetModel;
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
    private PetModel pet;
    private List<GeofenceModel> geofences = new ArrayList<>();
    private List<LocationModel> locations = new ArrayList<>();

    public DeviceModel toModel() {
        return new DeviceModel(
                this.id,
                this.deviceCodeIdentifier,
                this.deviceModel,
                this.deviceStatus,
                this.deviceSecretHash,
                this.deviceLastCommunication,
                this.userId,
                null,
                this.pet,
                this.locations,
                this.geofences
        );
    }

    public static Device fromModel(DeviceModel model) {
        return new Device(
                model.getId(),
                model.getDeviceCodeIdentifier(),
                model.getDeviceModel(),
                model.getDeviceStatus(),
                model.getDeviceSecretHash(),
                model.getDeviceLastCommunication(),
                model.getUserId(),
                model.getPet(),
                model.getGeofences(),
                model.getLocations()
        );
    }
}