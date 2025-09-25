package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
