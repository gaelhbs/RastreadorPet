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

    public Receipt create(Receipt entity) {
        ReceiptModel saved = receiptRepository.save(entity.toModel());
        return Receipt.fromModel(saved);
    }

    public List<Receipt> findAll() {
        return receiptRepository.findAll()
                .stream()
                .map(Receipt::fromModel)
                .collect(Collectors.toList());
    }

    public Receipt findById(int id) {
        return receiptRepository.findById(id)
                .map(Receipt::fromModel)
                .orElse(null);
    }

    public Receipt update(int id, Receipt entity) {
        if (!receiptRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        ReceiptModel updated = receiptRepository.save(entity.toModel());
        return Receipt.fromModel(updated);
    }

    public void delete(int id) {
        receiptRepository.deleteById(id);
    }
}