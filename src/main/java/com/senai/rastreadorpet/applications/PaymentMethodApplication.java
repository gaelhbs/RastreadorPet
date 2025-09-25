package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodApplication {

    private final PaymentMethodRepository repository;

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
