package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.models.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private SubscriptionStatus status;
    private List<ReceiptModel> receipt = new ArrayList<>();

}
