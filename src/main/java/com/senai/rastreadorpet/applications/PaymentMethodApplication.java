package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.PaymentMethod;
import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentMethodApplication {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod create(PaymentMethod entity) {
        PaymentMethodModel saved = paymentMethodRepository.save(entity.toModel());
        return PaymentMethod.fromModel(saved);
    }

    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll()
                .stream()
                .map(PaymentMethod::fromModel)
                .collect(Collectors.toList());
    }

    public PaymentMethod findById(int id) {
        return paymentMethodRepository.findById(id)
                .map(PaymentMethod::fromModel)
                .orElse(null);
    }

    public PaymentMethod update(int id, PaymentMethod entity) {
        if (!paymentMethodRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        PaymentMethodModel updated = paymentMethodRepository.save(entity.toModel());
        return PaymentMethod.fromModel(updated);
    }

    public void delete(int id) {
        paymentMethodRepository.deleteById(id);
    }
}
