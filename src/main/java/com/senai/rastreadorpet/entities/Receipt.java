package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.models.enums.ReceiptStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

    private int id;
    private BigDecimal valuePaid;
    private LocalDateTime paymentDate;
    private ReceiptStatus status;
    private int userId;
    private int subscriptionId;
    private int paymentMethodId;

    public ReceiptModel toModel() {
        return new ReceiptModel(
                this.id,
                this.valuePaid,
                this.paymentDate,
                this.status,
                this.userId,
                null,
                this.subscriptionId,
                null,
                this.paymentMethodId,
                null
        );
    }

    public static Receipt fromModel(ReceiptModel model) {
        return new Receipt(
                model.getId(),
                model.getValuePaid(),
                model.getPaymentDate(),
                model.getStatus(),
                model.getUserId(),
                model.getSubscriptionId(),
                model.getPaymentMethodId()
        );
    }
}
