package com.senai.rastreadorpet.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class PaymentMethodModel {
    private int id;
    private String method;
}
