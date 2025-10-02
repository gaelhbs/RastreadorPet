package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.SubscriptionApplication;
import com.senai.rastreadorpet.entities.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionApplication subscriptionApplication;

    public Subscription create(Subscription entity) {
        return subscriptionApplication.create(entity);
    }

    public List<Subscription> findAll() {
        return subscriptionApplication.findAll();
    }

    public Subscription findById(int id) {
        return subscriptionApplication.findById(id);
    }

    public Subscription update(int id, Subscription entity) {
        return subscriptionApplication.update(id, entity);
    }

    public void delete(int id) {
        subscriptionApplication.delete(id);
    }
}
