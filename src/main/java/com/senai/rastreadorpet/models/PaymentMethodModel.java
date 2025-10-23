package com.senai.rastreadorpet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_method")
public class PaymentMethodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id")
    private int id;

    @Column(name = "payment_method_name", nullable = false)
    private String method;

    /*
    @OneToMany(mappedBy = "paymentMethod")
    private List<ReceiptModel> receipt = new ArrayList<>();
    */
}
