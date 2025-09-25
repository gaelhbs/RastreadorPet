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
        List<DeviceEntity> pets = deviceFacade.findAll();
        return deviceFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceEntity createUser(@RequestBody DeviceEntity device) {
        return deviceFacade.create(device);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceEntity getUserById(@PathVariable int id) {
        return deviceFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeviceEntity updateUser(@PathVariable int id, @RequestBody DeviceEntity device) {
        return deviceFacade.update(id, device);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        deviceFacade.delete(id);
    }
}
