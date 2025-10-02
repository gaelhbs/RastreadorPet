package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.facade.AssinaturaFacade;
import com.senai.rastreadorpet.models.AssinaturaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinaturas")
@RequiredArgsConstructor
public class AssinaturaController {

    private final AssinaturaFacade facade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AssinaturaModel> getAll() {
        return facade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssinaturaModel create(@RequestBody AssinaturaModel model) {
        return facade.create(model);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssinaturaModel getById(@PathVariable Long id) {
        return facade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssinaturaModel update(@PathVariable Long id, @RequestBody AssinaturaModel model) {
        return facade.update(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facade.delete(id);
    }
}
