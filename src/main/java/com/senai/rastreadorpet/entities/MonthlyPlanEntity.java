package com.senai.rastreadorpet.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
@Setter
public class MonthlyPlanEntity {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
}
