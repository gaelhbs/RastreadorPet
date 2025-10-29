package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.SubscriptionModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class MonthlyPlan {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<SubscriptionModel> subscriptions = new ArrayList<>();
}
