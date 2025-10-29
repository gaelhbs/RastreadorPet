package com.senai.rastreadorpet.applications;


import com.senai.rastreadorpet.entities.MonthlyPlan;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import com.senai.rastreadorpet.repositories.MonthlyPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyPlanApplication {

    private final MonthlyPlanRepository repository;

    private MonthlyPlanModel toModel(MonthlyPlan entity) {
        MonthlyPlanModel model = new MonthlyPlanModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setPrice(entity.getPrice());
        model.setSubscriptions(entity.getSubscriptions());

        return model;
    }

    private MonthlyPlan toEntity(MonthlyPlanModel model) {
        MonthlyPlan entity = new MonthlyPlan();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
        entity.setSubscriptions(model.getSubscriptions());

        return entity;
    }


    public MonthlyPlanModel findById(int id){
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<MonthlyPlanModel> findAll(){
        return this.repository.findAll();
    }

    public void create(MonthlyPlanModel model){
        this.repository.save(model);
    }

    public MonthlyPlanModel update(int id, MonthlyPlanModel newData) {
        return this.repository.findById(id).map(exist -> {
            exist.setName(newData.getName());
            exist.setDescription(newData.getDescription());
            exist.setPrice(newData.getPrice());
            return this.repository.save(exist);
        }).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(int id){
        MonthlyPlanModel model = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        this.repository.delete(model);
    }

}
