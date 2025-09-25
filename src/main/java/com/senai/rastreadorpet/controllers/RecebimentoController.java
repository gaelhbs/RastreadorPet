package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.facade.RecebimentoFacade;
import com.senai.rastreadorpet.models.RecebimentoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recebimentos")
@RequiredArgsConstructor
public class RecebimentoController {

    private final RecebimentoFacade recebimentoFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecebimentoModel> getAll() {
        return recebimentoFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecebimentoModel create(@RequestBody RecebimentoModel recebimento) {
        return recebimentoFacade.create(recebimento);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecebimentoModel getById(@PathVariable int id) {
        return recebimentoFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecebimentoModel update(@PathVariable int id, @RequestBody RecebimentoModel recebimento) {
        return recebimentoFacade.update(id, recebimento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        recebimentoFacade.delete(id);
    }
}
