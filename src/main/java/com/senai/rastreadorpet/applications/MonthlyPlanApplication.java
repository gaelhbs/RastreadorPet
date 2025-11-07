package com.senai.rastreadorpet.applications;


import com.senai.rastreadorpet.entities.MonthlyPlan;
import com.senai.rastreadorpet.entities.Pet;
import com.senai.rastreadorpet.entities.Receipt;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.repositories.MonthlyPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonthlyPlanApplication {

    private final MonthlyPlanRepository repository;

    public MonthlyPlan create(MonthlyPlan entity) {
        MonthlyPlanModel saved = repository.save(entity.toModel());
        return MonthlyPlan.fromModel(saved);
    }

    public MonthlyPlan findById(int id) {
        return repository.findById(id)
                .map(MonthlyPlan::fromModel)
                .orElse(null);
    }

    public List<MonthlyPlan> findAll() {
        return repository.findAll()
                .stream()
                .map(MonthlyPlan::fromModel)
                .collect(Collectors.toList());
    }

    public MonthlyPlan update(int id, MonthlyPlan entity) {
        if (!repository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        MonthlyPlanModel updated = repository.save(entity.toModel());
        return MonthlyPlan.fromModel(updated);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
