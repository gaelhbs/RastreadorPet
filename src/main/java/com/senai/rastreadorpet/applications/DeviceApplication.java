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

    public Device create(Device entity) {
        DeviceModel saved = deviceRepository.save(entity.toModel());
        return Device.fromModel(saved);
    }

    public List<Device> findAll() {
        return deviceRepository.findAll()
                .stream()
                .map(Device::fromModel)
                .collect(Collectors.toList());
    }

    public Device findById(int id) {
        return deviceRepository.findById(id)
                .map(Device::fromModel)
                .orElse(null);
    }

    public Device update(int id, Device entity) {
        if (!deviceRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        DeviceModel updated = deviceRepository.save(entity.toModel());
        return Device.fromModel(updated);
    }

    public void delete(int id) {
        deviceRepository.deleteById(id);
    }
}
