package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.PaymentMethod;
import com.senai.rastreadorpet.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodApplication {

    private final PaymentMethodRepository repository;

    public PaymentMethod searchById(int id){
      return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<PaymentMethod> listAll(){
        return this.repository.findAll();
    }

    public void add(PaymentMethod entity){
        this.repository.save(entity);
    }

    public PaymentMethod update(int id, PaymentMethod newData) {
        return this.repository.findById(id).map(exist -> {
                    exist.setMethod(newData.getMethod());
                    return this.repository.save(exist);
                }).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void delete(int id){
        PaymentMethod entity = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        this.repository.delete(entity);

}

}
