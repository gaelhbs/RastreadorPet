package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.DeviceEntity;
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
    private DeviceModel toModel(DeviceEntity entity) {
        DeviceModel model = new DeviceModel();
        model.setId(entity.getId());
        model.setDeviceCodeIdentifier(entity.getDeviceCodeIdentifier());
        model.setDeviceModel(entity.getDeviceModel());
        model.setDeviceStatus(entity.getDeviceStatus());
        model.setDeviceSecretHash(entity.getDeviceSecretHash());
        model.setDeviceLastCommunication(entity.getDeviceLastCommunication());
        return model;
    }

    // Converte Model -> Entity
    private DeviceEntity toEntity(DeviceModel model) {
        DeviceEntity entity = new DeviceEntity();
        entity.setId(model.getId());
        entity.setDeviceCodeIdentifier(model.getDeviceCodeIdentifier());
        entity.setDeviceModel(model.getDeviceModel());
        entity.setDeviceStatus(model.getDeviceStatus());
        entity.setDeviceSecretHash(model.getDeviceSecretHash());
        entity.setDeviceLastCommunication(model.getDeviceLastCommunication());
        return entity;
    }

    public DeviceEntity create(DeviceEntity entity) {
        DeviceModel saved = deviceRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<DeviceEntity> findAll() {
        return deviceRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public DeviceEntity findById(int id) {
        return deviceRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public DeviceEntity update(int id, DeviceEntity entity) {
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
