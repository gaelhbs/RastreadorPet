package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.ReceiptStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipts")
public class ReceiptModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "receipt_value_paid", nullable = false)
    private BigDecimal valuePaid;

    @Column(name = "receipt_payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "receipt_status_payment", nullable = false)
    private ReceiptStatus status;

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserModel user;

    @Column(name = "subscription_id")
    private int subscriptionId;

    @ManyToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SubscriptionModel subscription;

    @Column(name = "payment_method_id")
    private int paymentMethodId;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PaymentMethodModel paymentMethod;

}
