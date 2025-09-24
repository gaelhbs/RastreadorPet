package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.Geofence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeofenceRepository extends JpaRepository<Geofence, Integer> {
}
