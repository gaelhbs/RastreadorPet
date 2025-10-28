package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.ReceiptModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class PaymentMethod {
    private int id;
    private String method;
    private List<ReceiptModel> receipt = new ArrayList<>();

}
