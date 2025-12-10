package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.GeofenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeofenceRepository extends JpaRepository<GeofenceModel, Integer> {
    List<GeofenceModel> findByDeviceId(int deviceId);
}
