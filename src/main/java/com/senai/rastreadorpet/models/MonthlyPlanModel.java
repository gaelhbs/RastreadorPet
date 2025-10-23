package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "monthly_plan")
public class MonthlyPlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monthly_plan_id")
    private int id;

    @Column(name = "monthly_plan_name", unique = true, nullable = false)
    private String name;

    @Column(name = "monthly_plan_description")
    private String description;

    @Column(name = "monthly_plan_price", nullable = false)
    private BigDecimal price;

     /*
    @OneToMany(mappedBy = "monthlyPlan")
    private List<SubscriptionModel> subscriptions = new ArrayList<>();
    */
}
