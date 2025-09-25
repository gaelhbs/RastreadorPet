package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.SubscriptionApplication;
import com.senai.rastreadorpet.models.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionApplication subscriptionApplication;

    public Subscription create(Subscription subscription) {
        return subscriptionApplication.create(subscription);
    }

    public Subscription findById(int id) {
        return subscriptionApplication.findById(id);
    }

   public Subscription update(Subscription subscription) {
        return subscriptionApplication.update(subscription);
   }
}
