package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.rastreadorpet.models.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "subscriptions")
public class SubscriptionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subscription_start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "subscription_end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_status", nullable = false)
    private SubscriptionStatus status;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserModel user;

    @Column(name = "monthly_plan_id")
    private int monthlyPlanId;

    @ManyToOne
    @JoinColumn(name = "monthly_plan_id", referencedColumnName = "id", insertable = false, updatable = false)
    private MonthlyPlanModel monthlyPlan;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<ReceiptModel> receipt = new ArrayList<>();
}
