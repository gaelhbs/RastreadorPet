package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.models.SubscriptionModel;
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
    private int userId;
    private int monthlyPlanId;
    private List<ReceiptModel> receipt = new ArrayList<>();

    public SubscriptionModel toModel() {
        return new SubscriptionModel(
                this.id,
                this.startDate,
                this.endDate,
                this.status,
                this.userId,
                null,
                this.monthlyPlanId,
                null,
                this.receipt
        );
    }

    public static Subscription fromModel(SubscriptionModel model) {
        return new Subscription(
                model.getId(),
                model.getStartDate(),
                model.getEndDate(),
                model.getStatus(),
                model.getUserId(),
                model.getMonthlyPlanId(),
                model.getReceipt()
        );
    }
}