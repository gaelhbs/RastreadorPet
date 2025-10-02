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
    @Column(name = "receipt_id")
    private int id;

    @Column(name = "receipt_value_paid", nullable = false)
    private BigDecimal valuePaid;

    @Column(name = "receipt_payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "receipt_status_payment", nullable = false)
    private ReceiptStatus status;

}
