package com.senai.rastreadorpet.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "monthly_plans")
public class MonthlyPlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private BigDecimal monthlyPrice;

    public MonthlyPlanModel() {
    }

    public MonthlyPlanModel(int id, String name, String description, BigDecimal monthlyPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monthlyPrice = monthlyPrice;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(BigDecimal monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

}
