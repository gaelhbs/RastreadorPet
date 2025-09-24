package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
