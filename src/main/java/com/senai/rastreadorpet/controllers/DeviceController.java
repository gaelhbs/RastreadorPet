package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.Device;
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
    public List<Device> getAllDevice() {
        List<Device> Device = deviceFacade.findAll();
        return deviceFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device createDevice(@RequestBody Device device) {
        return deviceFacade.create(device);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Device getDeviceById(@PathVariable int id) {
        return deviceFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Device updateDevice(@PathVariable int id, @RequestBody Device device) {
        return deviceFacade.update(id, device);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable int id) {
        deviceFacade.delete(id);
    }
}
