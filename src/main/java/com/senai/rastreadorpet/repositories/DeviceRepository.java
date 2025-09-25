package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceModel, Integer> {
}
