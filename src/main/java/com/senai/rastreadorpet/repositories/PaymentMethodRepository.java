package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.PaymentMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodModel, Integer> {

}
