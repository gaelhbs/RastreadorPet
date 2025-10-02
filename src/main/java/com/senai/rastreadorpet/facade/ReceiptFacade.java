package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Receipt;
import com.senai.rastreadorpet.applications.ReceiptApplication; // Import atualizado
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptFacade {

    @Autowired
    private ReceiptApplication receiptApplication; 

    public Receipt registerNewReceipt(Receipt receipt) {
        return receiptApplication.create(receipt);
    }
}
