package com.senai.rastreadorpet.applications;


import com.senai.rastreadorpet.models.MonthlyPlanModel;
import com.senai.rastreadorpet.repositories.MonthlyPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyPlanApplication {

    private final MonthlyPlanRepository repository;

    public MonthlyPlanModel searchById(int id){
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<MonthlyPlanModel> listAll(){
        return this.repository.findAll();
    }

    public void add(MonthlyPlanModel model){
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
