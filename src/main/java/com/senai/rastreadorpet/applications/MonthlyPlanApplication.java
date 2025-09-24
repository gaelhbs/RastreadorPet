package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.MonthlyPlan;
import com.senai.rastreadorpet.repositories.MonthlyPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyPlanApplication {

    private final MonthlyPlanRepository repository;

    public MonthlyPlan searchById(int id){
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<MonthlyPlan> listAll(){
        return this.repository.findAll();
    }

    public void add(MonthlyPlan entity){
        this.repository.save(entity);
    }

    public MonthlyPlan update(int id, MonthlyPlan newData) {
        return this.repository.findById(id).map(exist -> {
            exist.setName(newData.getName());
            exist.setDescription(newData.getDescription());
            exist.setPrice(newData.getPrice());
            return this.repository.save(exist);
        }).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(int id){
        MonthlyPlan entity = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        this.repository.delete(entity);
    }

}
