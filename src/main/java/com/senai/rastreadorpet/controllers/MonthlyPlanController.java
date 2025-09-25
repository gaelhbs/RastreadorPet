package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.facade.MonthlyPlanFacade;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/monthly-plans")
@RequiredArgsConstructor
public class MonthlyPlanController {

    private final MonthlyPlanFacade monthlyPlanFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MonthlyPlanModel> getAllPlans() {
        return monthlyPlanFacade.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MonthlyPlanModel getPlanById(@PathVariable int id) {
        return monthlyPlanFacade.searchById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlan(@RequestBody MonthlyPlanModel model) {
        monthlyPlanFacade.add(model);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MonthlyPlanModel updatePlan(@PathVariable int id, @RequestBody MonthlyPlanModel newData) {
        return monthlyPlanFacade.update(id, newData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlan(@PathVariable int id) {
        monthlyPlanFacade.delete(id);
    }
}
