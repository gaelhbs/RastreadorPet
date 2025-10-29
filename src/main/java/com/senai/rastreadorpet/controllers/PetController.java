package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.Pet;
import com.senai.rastreadorpet.facade.PetFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
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
        return petFacade.create(pet);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pet getUserById(@PathVariable int id) {
        return petFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pet updateUser(@PathVariable int id, @RequestBody Pet pet) {
        return petFacade.update(id, pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        petFacade.delete(id);
    }
}
