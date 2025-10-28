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

    // Converte Entity -> Model
    private SubscriptionModel toModel(Subscription entity) {
        SubscriptionModel model = new SubscriptionModel();
        model.setId(entity.getId());
        model.setStartDate(entity.getStartDate());
        model.setEndDate(entity.getEndDate());
        model.setStatus(entity.getStatus());
        model.setReceipt(entity.getReceipt());
        return model;
    }

    // Converte Model -> Entity
    private Subscription toEntity(SubscriptionModel model) {
        Subscription entity = new Subscription();
        entity.setId(model.getId());
        entity.setStartDate(model.getStartDate());
        entity.setEndDate(model.getEndDate());
        entity.setStatus(model.getStatus());
        entity.setReceipt(model.getReceipt());
        return entity;
    }

    public Subscription create(Subscription entity) {
        SubscriptionModel saved = subscriptionRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Subscription findById(int id) {
        return subscriptionRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Subscription update(int id, Subscription entity) {
        if (!subscriptionRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        SubscriptionModel updated = subscriptionRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        subscriptionRepository.deleteById(id);
    }
}
