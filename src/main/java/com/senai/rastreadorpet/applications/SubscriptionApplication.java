package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Subscription;
import com.senai.rastreadorpet.models.SubscriptionModel;
import com.senai.rastreadorpet.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionApplication {

    private final SubscriptionRepository subscriptionRepository;

    public Subscription create(Subscription entity) {
        SubscriptionModel saved = subscriptionRepository.save(entity.toModel());
        return Subscription.fromModel(saved);
    }

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll()
                .stream()
                .map(Subscription::fromModel)
                .collect(Collectors.toList());
    }

    public Subscription findById(int id) {
        return subscriptionRepository.findById(id)
                .map(Subscription::fromModel)
                .orElse(null);
    }

    public Subscription update(int id, Subscription entity) {
        if (!subscriptionRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        SubscriptionModel updated = subscriptionRepository.save(entity.toModel());
        return Subscription.fromModel(updated);
    }

    public void delete(int id) {
        subscriptionRepository.deleteById(id);
    }
}