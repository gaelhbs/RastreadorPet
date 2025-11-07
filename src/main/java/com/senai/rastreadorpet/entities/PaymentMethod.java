package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.models.ReceiptModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {
    private int id;
    private String method;
    private List<ReceiptModel> receipt = new ArrayList<>();

    public PaymentMethodModel toModel() {
        return new PaymentMethodModel(
                this.id,
                this.method,
                this.receipt

        );

    }

    public static PaymentMethod fromModel(PaymentMethodModel model) {
        return new PaymentMethod(
                model.getId(),
                model.getMethod(),
                model.getReceipt()

        );
    }
}
