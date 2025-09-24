package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.Pet;
import com.senai.rastreadorpet.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetApplication {

    private final PetRepository petRepository;

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }
}
