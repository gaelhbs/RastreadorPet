package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.LocationApplication;

import com.senai.rastreadorpet.entities.Location;
import com.senai.rastreadorpet.dto.LocationUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationFacade {
    private final LocationApplication locationApplication;

    public Location create(Location location) {
        return locationApplication.create(location);
    }

    public List<Location> findAll() {
        return locationApplication.findAll();
    }

    public Location findById(int id) {
        return locationApplication.findById(id);
    }

    public Location update(int id, LocationUpdateDTO locationUpdateDTO) {
        return locationApplication.update(id, locationUpdateDTO);
    }

    public void delete(int id) {
        locationApplication.delete(id);
    }
}
