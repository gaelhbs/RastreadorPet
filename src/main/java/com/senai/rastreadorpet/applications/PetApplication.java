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

    public Pet create(Pet entity) {
        PetModel saved = petRepository.save(entity.toModel());
        return Pet.fromModel(saved);
    }

    public List<Pet> findAll() {
        return petRepository.findAll()
                .stream()
                .map(Pet::fromModel)
                .collect(Collectors.toList());
    }

    public Pet findById(int id) {
        return petRepository.findById(id)
                .map(Pet::fromModel)
                .orElse(null);
    }

    public Pet update(int id, Pet entity) {
        if (!petRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        PetModel updated = petRepository.save(entity.toModel());
        return Pet.fromModel(updated);
    }

    public void delete(int id) {
        petRepository.deleteById(id);
    }
}

