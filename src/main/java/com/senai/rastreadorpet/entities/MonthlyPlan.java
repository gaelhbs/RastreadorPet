package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.MonthlyPlanModel;
import com.senai.rastreadorpet.models.SubscriptionModel;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyPlan {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<SubscriptionModel> subscriptions = new ArrayList<>();

    public MonthlyPlanModel toModel() {
        return new MonthlyPlanModel(
                this.id,
                this.name,
                this.description,
                this.price,
                this.subscriptions
        );
    }

    public static MonthlyPlan fromModel(MonthlyPlanModel model) {
        return new MonthlyPlan(
                model.getId(),
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                model.getSubscriptions()
        );
    }
}
