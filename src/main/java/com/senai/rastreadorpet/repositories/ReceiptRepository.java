package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.ReceiptModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<ReceiptModel, Integer> {
}
