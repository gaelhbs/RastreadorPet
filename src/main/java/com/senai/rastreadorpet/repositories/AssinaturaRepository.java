package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.AssinaaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<AssinaaturaEntity, Long> {
}

