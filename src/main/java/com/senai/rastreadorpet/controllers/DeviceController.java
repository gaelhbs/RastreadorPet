package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.DeviceEntity;
import com.senai.rastreadorpet.facade.DeviceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceFacade deviceFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeviceEntity> getAllDevice() {
        List<DeviceEntity> Device = deviceFacade.findAll();
        return deviceFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceEntity createDevice(@RequestBody DeviceEntity device) {
        return deviceFacade.create(device);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceEntity getDeviceById(@PathVariable int id) {
        return deviceFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceEntity updateDevice(@PathVariable int id, @RequestBody DeviceEntity device) {
        return deviceFacade.update(id, device);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable int id) {
        deviceFacade.delete(id);
    }
}
