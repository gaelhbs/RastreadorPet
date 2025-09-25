package com.senai.rastreadorpet.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class PaymentMethodEntity {
    private int id;
    private String method;
}
