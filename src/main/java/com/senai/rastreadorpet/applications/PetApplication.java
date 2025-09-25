package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.PetEntity;
import com.senai.rastreadorpet.models.Pet;
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
    private Pet toModel(PetEntity entity) {
        Pet model = new Pet();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSpecies(entity.getSpecies());
        model.setBreed(entity.getBreed());
        model.setBirthDate(entity.getBirthDate());
        model.setGender(entity.getGender());
        model.setPhotoUrl(entity.getPhotoUrl());
        return model;
    }

    // Converte Model -> Entity
    private PetEntity toEntity(Pet model) {
        PetEntity entity = new PetEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setSpecies(model.getSpecies());
        entity.setBreed(model.getBreed());
        entity.setBirthDate(model.getBirthDate());
        entity.setGender(model.getGender());
        entity.setPhotoUrl(model.getPhotoUrl());
        return entity;
    }

    public PetEntity create(PetEntity entity) {
        Pet saved = petRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<PetEntity> findAll() {
        return petRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public PetEntity findById(int id) {
        return petRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public PetEntity update(int id, PetEntity entity) {
        if (!petRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        Pet updated = petRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        petRepository.deleteById(id);
    }
}

