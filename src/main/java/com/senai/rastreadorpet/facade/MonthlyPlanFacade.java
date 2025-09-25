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

    public MonthlyPlanModel searchById(int id){
        return this.application.searchById(id);
    }

    public List<MonthlyPlanModel> listAll(){
        return this.application.listAll();
    }

    public void add(MonthlyPlanModel model){
        this.application.add(model);
    }

    public MonthlyPlanModel update(int id, MonthlyPlanModel newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }
}
