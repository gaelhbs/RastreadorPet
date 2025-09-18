package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.ReceiptStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recebimentos")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recebimento_id")
    private int id;

    @Column(name = "recebimento_valor_pago", nullable = false)
    private BigDecimal amount;

    @Column(name = "recebimento_data_pagamento", nullable = false)
    private LocalDateTime receiptDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "recebimento_status_pagamento", nullable = false)
    private ReceiptStatus status;

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDateTime receiptDate) {
        this.receiptDate = receiptDate;
    }

    public ReceiptStatus getStatus() {
        return status;
    }

    public void setStatus(ReceiptStatus status) {
        this.status = status;
    }
}
