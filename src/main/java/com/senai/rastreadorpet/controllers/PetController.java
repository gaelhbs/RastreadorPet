package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.facade.PetFacade;
import com.senai.rastreadorpet.models.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetFacade petFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pet> getAllPets() {
        List<Pet> pets = petFacade.findAll();
        return petFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet createUser(@RequestBody Pet pet) {
        return petFacade.save(pet);

    }
}
