package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Integer>{
}
