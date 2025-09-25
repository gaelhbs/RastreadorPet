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

    public PaymentMethodModel searchById(int id){
        return this.application.searchById(id);
    }

    public List<PaymentMethodModel> listAll(){
        return this.application.listAll();
    }

    public void add(PaymentMethodModel model){
        this.application.add(model);
    }

    public PaymentMethodModel update(int id, PaymentMethodModel newData) {
        return this.application.update(id, newData);
    }

    public void delete(int id){
        this.application.delete(id);
    }

}
