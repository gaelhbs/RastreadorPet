package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Pet;
import com.senai.rastreadorpet.models.PetModel;
import com.senai.rastreadorpet.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetApplication {

    private final PetRepository petRepository;

    // Converte Entity -> Model
    private PetModel toModel(Pet entity) {
        PetModel model = new PetModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSpecies(entity.getSpecies());
        model.setBreed(entity.getBreed());
        model.setBirthDate(entity.getBirthDate());
        model.setGender(entity.getGender());
        model.setPhotoUrl(entity.getPhotoUrl());
        model.setAlerts(entity.getAlerts());
        return model;
    }

    // Converte Model -> Entity
    private Pet toEntity(PetModel model) {
        Pet entity = new Pet();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setSpecies(model.getSpecies());
        entity.setBreed(model.getBreed());
        entity.setBirthDate(model.getBirthDate());
        entity.setGender(model.getGender());
        entity.setPhotoUrl(model.getPhotoUrl());
        entity.setAlerts(model.getAlerts());
        return entity;
    }

    public Pet create(Pet entity) {
        PetModel saved = petRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<Pet> findAll() {
        return petRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Pet findById(int id) {
        return petRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public Pet update(int id, Pet entity) {
        if (!petRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        PetModel updated = petRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        petRepository.deleteById(id);
    }
}

