package com.senai.rastreadorpet.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "monthly_plan")
public class MonthlyPlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public MonthlyPlanModel() {
    }

    public MonthlyPlanModel(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
        return price;
    }

    public void setMonthlyPrice(BigDecimal monthlyPrice) {
        this.price = monthlyPrice;
    }

     /*
    @OneToMany(mappedBy = "monthlyPlan")
    private List<SubscriptionModel> subscriptions = new ArrayList<>();
    */
}
