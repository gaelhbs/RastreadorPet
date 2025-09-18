package com.senai.rastreadorpet.services;

import com.senai.rastreadorpet.models.Pet;
import com.senai.rastreadorpet.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet salvar(Pet pet) {
        // Futuramente, aqui entrarão as regras de negócio.
        return petRepository.save(pet);
    }
}
