package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.PetEntity;
import com.senai.rastreadorpet.facade.PetFacade;
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
    public List<PetEntity> getAllPets() {
        List<PetEntity> pets = petFacade.findAll();
        return petFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetEntity createUser(@RequestBody PetEntity pet) {
        return petFacade.create(pet);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PetEntity getUserById(@PathVariable int id) {
        return petFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PetEntity updateUser(@PathVariable int id, @RequestBody PetEntity pet) {
        return petFacade.update(id, pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        petFacade.delete(id);
    }
}
