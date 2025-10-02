package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.AlertModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<AlertModel, Integer> {
}
