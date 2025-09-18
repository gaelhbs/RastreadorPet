package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.PetApplication;
import com.senai.rastreadorpet.models.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetFacade {

    private final PetApplication petApplication;

    public Pet save(Pet pet) {
        return petApplication.save(pet);
    }

    public List<Pet> findAll() {
        return petApplication.findAll();
    }
}
