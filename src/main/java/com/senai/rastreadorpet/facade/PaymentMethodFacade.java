package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.PaymentMethodApplication;
import com.senai.rastreadorpet.entities.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentMethodFacade {

    private final PaymentMethodApplication application;

    public PaymentMethod findById(int id) {
        return this.application.findById(id);
    }

    public List<PaymentMethod> findAll() {
        return this.application.findAll();
    }

    public PaymentMethod create(PaymentMethod entity) {
        return this.application.create(entity);
    }

    public PaymentMethod update(int id, PaymentMethod newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }

}
