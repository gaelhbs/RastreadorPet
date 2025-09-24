package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Integer> {
}
