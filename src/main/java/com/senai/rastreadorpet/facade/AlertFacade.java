package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.AlertApplication;
import com.senai.rastreadorpet.entities.AlertEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AlertFacade {
    private final AlertApplication alertApplication;

    public AlertEntity create(AlertEntity pet) {
        return alertApplication.create(pet);
    }

    public List<AlertEntity> findAll() {
        return alertApplication.findAll();
    }

    public AlertEntity findById(int id) {
        return alertApplication.findById(id);
    }

    public AlertEntity update(int id, AlertEntity entity) {
        return alertApplication.update(id, entity);
    }

    public void delete(int id) {
        alertApplication.delete(id);
    }
}
