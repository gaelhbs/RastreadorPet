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

    public PaymentMethod searchById(int id){
        return this.application.searchById(id);
    }

    public List<PaymentMethod> listAll(){
        return this.application.listAll();
    }

    public void add(PaymentMethod entity){
        this.application.add(entity);
    }

    public PaymentMethod update(int id, PaymentMethod newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }

}
