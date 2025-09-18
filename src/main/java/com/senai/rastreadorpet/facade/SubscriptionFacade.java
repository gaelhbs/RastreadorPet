package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.SubscriptionApplication;
import com.senai.rastreadorpet.models.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionApplication subscriptionApplication;

    public Subscription createNewSubscription(Subscription subscription) {
        return subscriptionApplication.save(subscription);
    }

    public Subscription cancelSubscription(int subscriptionId) {
        return subscriptionApplication.cancel(subscriptionId);
    }

    public Subscription reactivateSubscription(int subscriptionId) {
        return subscriptionApplication.reactivate(subscriptionId);
    }
}
