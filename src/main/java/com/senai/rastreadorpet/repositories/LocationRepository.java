package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer>{
}
