package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.Subscription;
import com.senai.rastreadorpet.facade.SubscriptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionFacade subscriptionFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionFacade.findAll();
        return subscriptionFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionFacade.create(subscription);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subscription getSubscriptionById(@PathVariable int id) {
        return subscriptionFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subscription updateSubscription(@PathVariable int id, @RequestBody Subscription subscription) {
        return subscriptionFacade.update(id, subscription);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubscription(@PathVariable int id) {
        subscriptionFacade.delete(id);
    }
}
