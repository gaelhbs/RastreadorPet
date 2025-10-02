package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Integer> {
}
