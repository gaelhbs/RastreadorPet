package com.senai.rastreadorpet.repositories;

import com.senai.rastreadorpet.entities.MonthlyPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyPlanRepository extends JpaRepository<MonthlyPlan, Integer> {
}
