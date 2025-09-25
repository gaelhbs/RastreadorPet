package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.MonthlyPlanApplication;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MonthlyPlanFacade {

    private final MonthlyPlanApplication application;

    public MonthlyPlanModel findById(int id){
        return this.application.findById(id);
    }

    public List<MonthlyPlanModel> listAll(){
        return this.application.findAll();
    }

    public void create(MonthlyPlanModel model){
        this.application.create(model);
    }

    public MonthlyPlanModel update(int id, MonthlyPlanModel newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }
}
