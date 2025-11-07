package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.*;
import com.senai.rastreadorpet.models.MonthlyPlanModel;
import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.models.SubscriptionModel;
import com.senai.rastreadorpet.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentMethodApplication {

    private final PaymentMethodRepository repository;

    private PaymentMethodModel toModel(PaymentMethod entity) {
        PaymentMethodModel model = new PaymentMethodModel();

        model.setId(entity.getId());
        model.setMethod(entity.getMethod());
        model.setReceipt(entity.getReceipt());

        return model;
    }


    private PaymentMethod toEntity(PaymentMethodModel model) {
        PaymentMethod entity = new PaymentMethod();

        entity.setId(model.getId());
        entity.setMethod(model.getMethod());
        entity.setReceipt(model.getReceipt());

        return entity;
    }


    public PaymentMethod findById(int id) {
        return repository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public List<PaymentMethod> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public PaymentMethod create(PaymentMethod entity){
        PaymentMethodModel saved = this.repository.save(toModel(entity));;
        return toEntity(saved);
    }

    public PaymentMethod update(int id, PaymentMethod entity) {
        if (!repository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        PaymentMethodModel updated = repository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
