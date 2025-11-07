package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.MonthlyPlanApplication;
import com.senai.rastreadorpet.entities.MonthlyPlan;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MonthlyPlanFacade {

    private final MonthlyPlanApplication application;

    public MonthlyPlan findById(int id){
        return this.application.findById(id);
    }

    public List<MonthlyPlan> listAll(){
        return this.application.findAll();
    }

    public void create(MonthlyPlan monthlyPlan){
        this.application.create(monthlyPlan);
    }

    public MonthlyPlan update(int id, MonthlyPlan newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }
}
