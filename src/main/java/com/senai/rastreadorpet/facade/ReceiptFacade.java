package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.UserApplication;
import com.senai.rastreadorpet.entities.Receipt;
import com.senai.rastreadorpet.entities.UserEntity;
import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.applications.ReceiptApplication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
