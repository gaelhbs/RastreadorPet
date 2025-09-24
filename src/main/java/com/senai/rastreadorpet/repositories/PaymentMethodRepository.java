package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

}
