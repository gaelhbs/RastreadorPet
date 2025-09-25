package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationModel, Integer>{
}
