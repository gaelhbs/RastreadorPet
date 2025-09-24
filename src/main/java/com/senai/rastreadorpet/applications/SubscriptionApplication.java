package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionApplication {

    public Subscription save(Subscription subscription) {
        return null;
    }

    public Subscription cancel(int subscriptionId) {
        return null;
    }

    public Subscription reactivate(int subscriptionId) {
        return null;
    }
}
