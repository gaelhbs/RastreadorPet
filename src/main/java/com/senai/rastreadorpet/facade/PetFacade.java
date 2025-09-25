package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.PetApplication;
import com.senai.rastreadorpet.entities.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetFacade {

    private final PetApplication petApplication;

    public PetEntity create(PetEntity pet) {
        return petApplication.create(pet);
    }

    public List<PetEntity> findAll() {
        return petApplication.findAll();
    }

    public PetEntity findById(int id) {
        return petApplication.findById(id);
    }

    public PetEntity update(int id, PetEntity entity) {
        return petApplication.update(id, entity);
    }

    public void delete(int id) {
        petApplication.delete(id);
    }
}
