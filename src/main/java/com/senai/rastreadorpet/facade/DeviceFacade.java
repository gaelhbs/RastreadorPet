package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.entities.DeviceEntity;
import com.senai.rastreadorpet.applications.DeviceApplication;
import com.senai.rastreadorpet.repositories.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeviceFacade {
    private final DeviceApplication deviceApplication;

    public DeviceEntity create(DeviceEntity device) {
        return deviceApplication.create(device);
    }

    public List<DeviceEntity> findAll() {
        return deviceApplication.findAll();
    }

    public DeviceEntity findById(int id) {
        return deviceApplication.findById(id);
    }

    public DeviceEntity update(int id, DeviceEntity entity) {
        return deviceApplication.update(id, entity);
    }

    public void delete(int id) {
        deviceApplication.delete(id);
    }
}
