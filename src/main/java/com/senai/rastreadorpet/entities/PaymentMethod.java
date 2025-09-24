package com.senai.rastreadorpet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "method")
    private String method;

    /*
    @OneToMany(mappedBy = "paymentMethod")
    private List<ReceiptModel> receipt = new ArrayList<>();
    */
}
