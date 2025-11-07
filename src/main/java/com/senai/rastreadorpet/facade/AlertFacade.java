package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.AlertApplication;
import com.senai.rastreadorpet.entities.Alert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AlertFacade {
    private final AlertApplication alertApplication;

    public Alert create(Alert entity) {
        return alertApplication.create(entity);
    }

    public List<Alert> findAll() {
        return alertApplication.findAll();
    }

    public Alert findById(int id) {
        return alertApplication.findById(id);
    }

    public Alert update(int id, Alert entity) {
        return alertApplication.update(id, entity);
    }

    public void delete(int id) {
        alertApplication.delete(id);
    }
}
