package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.Alert;
import com.senai.rastreadorpet.facade.AlertFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertFacade alertFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Alert> getAllAlerts() {
        return alertFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Alert createAlert(@RequestBody Alert alert) {
        return alertFacade.create(alert);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Alert getAlertById(@PathVariable int id) {
        return alertFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Alert updateAlert(@PathVariable int id, @RequestBody Alert alert) {
        return alertFacade.update(id, alert);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlert(@PathVariable int id) {
        alertFacade.delete(id);
    }
}
