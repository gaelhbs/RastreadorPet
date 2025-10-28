package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.entities.Receipt;
import com.senai.rastreadorpet.applications.ReceiptApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReceiptFacade {

    private final ReceiptApplication receiptApplication;

    public Receipt create(Receipt entity) {
        return receiptApplication.create(entity);
    }

    public List<Receipt> findAll() {
        return receiptApplication.findAll();
    }

    public Receipt findById(int id) {
        return receiptApplication.findById(id);
    }

    public Receipt update(int id, Receipt entity) {
        return receiptApplication.update(id, entity);
    }

    public void delete(int id) {
        receiptApplication.delete(id);
    }
}
