package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.AlertEntity;
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

    // Converte Entity -> Model
    private AlertModel toModel(AlertEntity entity) {
        AlertModel model = new AlertModel();
        model.setId(entity.getId());
        model.setAlertRead(entity.getAlertRead());
        model.setDateTime(entity.getDateTime());
        model.setTypeAlert(entity.getTypeAlert());
        return model;
    }

    // Converte Model -> Entity
    private AlertEntity toEntity(AlertModel model) {
        AlertEntity entity = new AlertEntity();
        entity.setId(model.getId());
        entity.setAlertRead(model.getAlertRead());
        entity.setDateTime(model.getDateTime());
        entity.setTypeAlert(model.getTypeAlert());
        return entity;
    }

    public AlertEntity create(AlertEntity entity) {
        AlertModel saved = alertRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<AlertEntity> findAll() {
        return alertRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public AlertEntity findById(int id) {
        return alertRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public AlertEntity update(int id, AlertEntity entity) {
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

