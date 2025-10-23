package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.Receipt;
import com.senai.rastreadorpet.facade.ReceiptFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptFacade receiptFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Receipt> getAllReceipts() {
        List<Receipt> receipts = receiptFacade.findAll();
        return receiptFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receipt createReceipt(@RequestBody Receipt receipt) {
        return receiptFacade.create(receipt);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receipt getReceiptById(@PathVariable int id) {
        return receiptFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receipt updateSubscription(@PathVariable int id, @RequestBody Receipt receipt) {
        return receiptFacade.update(id, receipt);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubscription(@PathVariable int id) {
        receiptFacade.delete(id);
    }
}
