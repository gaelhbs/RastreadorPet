package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Subscription;
import com.senai.rastreadorpet.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionFacade {

    @Autowired
    private SubscriptionService subscriptionService;

    public Subscription createNewSubscription(Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    public Subscription cancelSubscription(int subscriptionId) {
        return subscriptionService.cancel(subscriptionId);
    }

    public Subscription reactivateSubscription(int subscriptionId) {
        return subscriptionService.reactivate(subscriptionId);
    }
}
