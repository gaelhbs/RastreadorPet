package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Receipt;
import com.senai.rastreadorpet.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiptFacade {

    @Autowired
    private ReceiptService receiptService;

    public Receipt registerNewReceipt(Receipt receipt) {
        return receiptService.save(receipt);
    }
}
