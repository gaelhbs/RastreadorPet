package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.entities.Device;
import com.senai.rastreadorpet.applications.DeviceApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeviceFacade {
    private final DeviceApplication deviceApplication;

    public Device create(Device device) {
        return deviceApplication.create(device);
    }

    public List<Device> findAll() {
        return deviceApplication.findAll();
    }

    public Device findById(int id) {
        return deviceApplication.findById(id);
    }

    public Device update(int id, Device entity) {
        return deviceApplication.update(id, entity);
    }

    public void delete(int id) {
        deviceApplication.delete(id);
    }
}
