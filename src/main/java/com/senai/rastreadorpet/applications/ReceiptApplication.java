package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.models.Receipt;
import com.senai.rastreadorpet.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service // A anotação @Service ainda é usada, pois indica ao Spring que é um componente da camada de serviço/aplicação
public class ReceiptApplication {

    @Autowired
    private ReceiptRepository receiptRepository;

    public Receipt save(Receipt receipt) {
        // Business rule: Set the receipt date at the moment of processing if not already set.
        if (receipt.getReceiptDate() == null) {
            receipt.setReceiptDate(LocalDateTime.now());
        }
        return receiptRepository.save(receipt);
    }
}
