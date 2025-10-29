package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.PaymentMethod;
import com.senai.rastreadorpet.entities.Subscription;
import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.models.SubscriptionModel;
import com.senai.rastreadorpet.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodApplication {

    private final PaymentMethodRepository repository;

    private PaymentMethodModel toModel(PaymentMethod entity) {
        PaymentMethodModel model = new PaymentMethodModel();

        model.setId(entity.getId());
        model.setMethod(entity.getMethod());
        model.setReceipt(entity.getReceipt());

        return model;
    }


    private PaymentMethod toEntity(PaymentMethodModel model) {
        PaymentMethod entity = new PaymentMethod();

        entity.setId(model.getId());
        entity.setMethod(model.getMethod());
        entity.setReceipt(model.getReceipt());

        return entity;
    }


    public PaymentMethodModel findById(int id){
      return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<PaymentMethodModel> findAll(){
        return this.repository.findAll();
    }

    public void create(PaymentMethodModel model){
        this.repository.save(model);
    }

    public PaymentMethodModel update(int id, PaymentMethodModel newData) {
        return this.repository.findById(id).map(exist -> {
                    exist.setMethod(newData.getMethod());
                    return this.repository.save(exist);
                }).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(int id){
        PaymentMethodModel model = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        this.repository.delete(model);

}

}
