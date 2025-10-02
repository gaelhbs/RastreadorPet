package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.RecebimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecebimentoRepository extends JpaRepository<RecebimentoEntity, Long> {
}
