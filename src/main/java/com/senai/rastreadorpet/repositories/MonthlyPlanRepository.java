package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.models.MonthlyPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyPlanRepository extends JpaRepository<MonthlyPlanModel, Integer> {
}
