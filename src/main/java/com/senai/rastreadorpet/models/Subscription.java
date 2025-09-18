package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.SubscriptionStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assinaturas")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assinatura_id")
    private int id;

    @Column(name = "assinatura_data_inicio", nullable = false)
    private LocalDate startDate;

    @Column(name = "assinatura_data_fim")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "assinatura_status", nullable = false)
    private SubscriptionStatus status;

    // Getters and Setters

    public int getId() {
        return id;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }
}
