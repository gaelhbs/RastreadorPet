package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Pet;
import com.senai.rastreadorpet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetFacade {

    @Autowired
    private PetService petService;

    public Pet cadastrarNovoPet(Pet pet) {
        return petService.salvar(pet);
    }
}
