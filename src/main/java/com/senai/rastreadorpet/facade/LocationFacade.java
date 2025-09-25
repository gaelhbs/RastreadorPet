package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.LocationApplication;

import com.senai.rastreadorpet.entities.LocationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocationFacade {
    private final LocationApplication locationApplication;

    public LocationEntity create(LocationEntity location) {
        return locationApplication.create(location);
    }

    public List<LocationEntity> findAll() {
        return locationApplication.findAll();
    }

    public LocationEntity findById(int id) {
        return locationApplication.findById(id);
    }

    public LocationEntity update(int id, LocationEntity entity) {
        return locationApplication.update(id, entity);
    }

    public void delete(int id) {
        locationApplication.delete(id);
    }
}
