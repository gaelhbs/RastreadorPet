package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Alert;
import com.senai.rastreadorpet.models.AlertModel;
import com.senai.rastreadorpet.repositories.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertApplication {

    private final AlertRepository alertRepository;

    private AlertModel toModel(Alert entity) {
        AlertModel model = new AlertModel();
        model.setId(entity.getId());
        model.setAlertRead(entity.getAlertRead());
        model.setDateTime(entity.getDateTime());
        model.setTypeAlert(entity.getTypeAlert());
        model.setPetId(entity.getPetId());
        model.setGeofenceId(entity.getGeofenceId());
        return model;
    }

    private Alert toEntity(AlertModel model) {
        Alert entity = new Alert();
        entity.setId(model.getId());
        entity.setAlertRead(model.getAlertRead());
        entity.setDateTime(model.getDateTime());
        entity.setTypeAlert(model.getTypeAlert());
        entity.setPetId(model.getPetId());
        entity.setGeofenceId(model.getGeofenceId());
        return entity;
    }

    public Alert create(Alert entity) {
        AlertModel saved = alertRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Alert> findAll() {
        return alertRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Alert findById(int id) {
        return alertRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Alert update(int id, Alert entity) {
        if (!alertRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        AlertModel updated = alertRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        alertRepository.deleteById(id);
    }
}

