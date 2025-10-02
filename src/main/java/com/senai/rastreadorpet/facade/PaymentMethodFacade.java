package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.PaymentMethodApplication;
import com.senai.rastreadorpet.models.PaymentMethodModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentMethodFacade {

    private final PaymentMethodApplication application;

    public PaymentMethodModel findById(int id){
        return this.application.findById(id);
    }

    public List<PaymentMethodModel> findAll(){
        return this.application.findAll();
    }

    public void create(PaymentMethodModel model){
        this.application.create(model);
    }

    public PaymentMethodModel update(int id, PaymentMethodModel newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }

}
