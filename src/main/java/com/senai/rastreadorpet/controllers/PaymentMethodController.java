package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.PaymentMethod;
import com.senai.rastreadorpet.facade.PaymentMethodFacade;
import com.senai.rastreadorpet.models.PaymentMethodModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodFacade paymentMethodFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentMethod getPaymentMethodById(@PathVariable int id) {
        return paymentMethodFacade.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPaymentMethod(@RequestBody PaymentMethod entity) {
        paymentMethodFacade.create(entity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentMethod updatePaymentMethod(@PathVariable int id, @RequestBody PaymentMethod newData) {
        return paymentMethodFacade.update(id, newData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaymentMethod(@PathVariable int id) {
        paymentMethodFacade.delete(id);
    }
}