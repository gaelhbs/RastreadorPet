package com.senai.rastreadorpet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_method")
public class PaymentMethodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "method")
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
    @OneToMany(mappedBy = "paymentMethod")
    private List<ReceiptModel> receipt = new ArrayList<>();
    */
}
