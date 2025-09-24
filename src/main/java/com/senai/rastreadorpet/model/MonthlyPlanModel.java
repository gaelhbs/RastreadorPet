package com.senai.rastreadorpet.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
@Setter
public class MonthlyPlanModel {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
}
