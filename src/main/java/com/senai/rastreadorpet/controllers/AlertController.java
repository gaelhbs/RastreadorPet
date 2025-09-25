package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.AlertEntity;
import com.senai.rastreadorpet.facade.AlertFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertFacade alertFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlertEntity> getAllAlerts() {
        List<AlertEntity> alerts = alertFacade.findAll();
        return alertFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertEntity createUser(@RequestBody AlertEntity alert) {
        return alertFacade.create(alert);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlertEntity getUserById(@PathVariable int id) {
        return alertFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlertEntity updateUser(@PathVariable int id, @RequestBody AlertEntity alert) {
        return alertFacade.update(id, alert);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        alertFacade.delete(id);
    }
}
