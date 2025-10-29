package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Device;
import com.senai.rastreadorpet.models.DeviceModel;
import com.senai.rastreadorpet.repositories.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceApplication {
    private final DeviceRepository deviceRepository;

    // Converte Entity -> Model
    private DeviceModel toModel(Device entity) {
        DeviceModel model = new DeviceModel();
        model.setId(entity.getId());
        model.setDeviceCodeIdentifier(entity.getDeviceCodeIdentifier());
        model.setDeviceModel(entity.getDeviceModel());
        model.setDeviceStatus(entity.getDeviceStatus());
        model.setDeviceSecretHash(entity.getDeviceSecretHash());
        model.setDeviceLastCommunication(entity.getDeviceLastCommunication());
        model.setLocations(entity.getLocations());
        return model;
    }

    // Converte Model -> Entity
    private Device toEntity(DeviceModel model) {
        Device entity = new Device();
        entity.setId(model.getId());
        entity.setDeviceCodeIdentifier(model.getDeviceCodeIdentifier());
        entity.setDeviceModel(model.getDeviceModel());
        entity.setDeviceStatus(model.getDeviceStatus());
        entity.setDeviceSecretHash(model.getDeviceSecretHash());
        entity.setDeviceLastCommunication(model.getDeviceLastCommunication());
        entity.setLocations(model.getLocations());
        return entity;
    }

    public Device create(Device entity) {
        DeviceModel saved = deviceRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Device> findAll() {
        return deviceRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Device findById(int id) {
        return deviceRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Device update(int id, Device entity) {
        if (!deviceRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        DeviceModel updated = deviceRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        deviceRepository.deleteById(id);
    }

}
