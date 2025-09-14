package com.senai.rastreadorpet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_methods")
public class PaymentMethodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String method;

    public PaymentMethodModel() {
    }

    public PaymentMethodModel(int id, String method) {
        this.id = id;
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    //@ManyToOne
    //@JoinColumn(name = "receipt_id")
    //private Receipt receipt;
}
