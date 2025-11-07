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

    public Alert create(Alert entity) {
        AlertModel saved = alertRepository.save(entity.toModel());
        return Alert.fromModel(saved);
    }

    public List<Alert> findAll() {
        return alertRepository.findAll()
                .stream()
                .map(Alert::fromModel)
                .collect(Collectors.toList());
    }

    public Alert findById(int id) {
        return alertRepository.findById(id)
                .map(Alert::fromModel)
                .orElse(null);
    }

    public Alert update(int id, Alert entity) {
        if (!alertRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        AlertModel updated = alertRepository.save(entity.toModel());
        return Alert.fromModel(updated);
    }

    public void delete(int id) {
        alertRepository.deleteById(id);
    }
}

