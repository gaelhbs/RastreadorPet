package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {
}
