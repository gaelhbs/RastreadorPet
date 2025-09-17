package com.senai.rastreadorpet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pagamento")
public class PaymentMethodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "forma")
    private String method;

    public PaymentMethodModel() {
    }

    public PaymentMethodModel(String method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /*
    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private ReceiptModel receipt;
    */
}
