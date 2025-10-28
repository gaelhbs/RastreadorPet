package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.models.enums.ReceiptStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

    private int id;
    private BigDecimal valuePaid;
    private LocalDateTime paymentDate;
    private ReceiptStatus status;
}
