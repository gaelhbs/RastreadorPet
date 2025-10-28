package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.PetApplication;
import com.senai.rastreadorpet.entities.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetFacade {

    private final PetApplication petApplication;

    public Pet create(Pet pet) {
        return petApplication.create(pet);
    }

    public List<Pet> findAll() {
        return petApplication.findAll();
    }

    public Pet findById(int id) {
        return petApplication.findById(id);
    }

    public Pet update(int id, Pet entity) {
        return petApplication.update(id, entity);
    }

    public void delete(int id) {
        petApplication.delete(id);
    }
}
