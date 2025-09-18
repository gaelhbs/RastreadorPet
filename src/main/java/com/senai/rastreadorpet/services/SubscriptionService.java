package com.senai.rastreadorpet.services;

import com.senai.rastreadorpet.models.Subscription;
import com.senai.rastreadorpet.models.enums.SubscriptionStatus;
import com.senai.rastreadorpet.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription save(Subscription subscription) {
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        return subscriptionRepository.save(subscription);
    }

    public Subscription cancel(int id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription with ID " + id + " not found."));

        subscription.setStatus(SubscriptionStatus.CANCELLED);
        subscription.setEndDate(LocalDate.now());

        return subscriptionRepository.save(subscription);
    }

    public Subscription reactivate(int id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription with ID " + id + " not found."));

        if (subscription.getStatus() == SubscriptionStatus.ACTIVE) {
            throw new IllegalStateException("The subscription is already active.");
        }

        subscription.setStatus(SubscriptionStatus.ACTIVE);
        subscription.setEndDate(null);

        return subscriptionRepository.save(subscription);
    }
}
