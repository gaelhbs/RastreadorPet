package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.ReceiptModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<ReceiptModel, Integer> {
}
