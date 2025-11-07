package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.MonthlyPlan;
import com.senai.rastreadorpet.facade.MonthlyPlanFacade;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/monthly-plans")
@RequiredArgsConstructor
public class MonthlyPlanController {

    private final MonthlyPlanFacade monthlyPlanFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MonthlyPlan> getAllPlans() {
        return monthlyPlanFacade.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MonthlyPlan getPlanById(@PathVariable int id) {
        return monthlyPlanFacade.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlan(@RequestBody MonthlyPlan entity) {
        monthlyPlanFacade.create(entity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MonthlyPlan updatePlan(@PathVariable int id, @RequestBody MonthlyPlan newData) {
        return monthlyPlanFacade.update(id, newData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlan(@PathVariable int id) {
        monthlyPlanFacade.delete(id);
    }
}
