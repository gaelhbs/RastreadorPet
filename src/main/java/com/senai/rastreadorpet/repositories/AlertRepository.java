package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.AlertModel;
import com.senai.rastreadorpet.models.GeofenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AlertRepository extends JpaRepository<AlertModel, Integer> {
}
