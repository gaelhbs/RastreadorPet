package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.entities.UserEntity;
import com.senai.rastreadorpet.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade  userFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userFacade.findAll();
        return userFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userFacade.create(user);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity getUserById(@PathVariable int id) {
        return userFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity user) {
        return userFacade.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        userFacade.delete(id);
    }

}
