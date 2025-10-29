package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Receipt;
import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.repositories.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiptApplication {

    private final ReceiptRepository receiptRepository;

    // Converte Entity -> Model
    private ReceiptModel toModel(Receipt entity) {
        ReceiptModel model = new ReceiptModel();
        model.setId(entity.getId());
        model.setStatus(entity.getStatus());
        model.setPaymentDate(entity.getPaymentDate());
        model.setValuePaid(entity.getValuePaid());
        model.setUserId(entity.getUserId());
        model.setSubscriptionId(entity.getSubscriptionId());
        model.setPaymentMethodId(entity.getPaymentMethodId());
        return model;
    }

    // Converte Model -> Entity
    private Receipt toEntity(ReceiptModel model) {
        Receipt entity = new Receipt();
        entity.setId(model.getId());
        entity.setStatus(model.getStatus());
        entity.setPaymentDate(model.getPaymentDate());
        entity.setValuePaid(model.getValuePaid());
        entity.setUserId(model.getUserId());
        entity.setSubscriptionId(model.getSubscriptionId());
        entity.setPaymentMethodId(model.getPaymentMethodId());
        return entity;
    }

    public Receipt create(Receipt entity) {
        ReceiptModel saved = receiptRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Receipt> findAll() {
        return receiptRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Receipt findById(int id) {
        return receiptRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Receipt update(int id, Receipt entity) {
        if (!receiptRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        ReceiptModel updated = receiptRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        receiptRepository.deleteById(id);
    }

}
