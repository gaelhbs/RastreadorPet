package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetModel, Integer> {
}
