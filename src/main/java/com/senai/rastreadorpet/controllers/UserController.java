package com.senai.rastreadorpet.controllers;

import com.senai.rastreadorpet.model.UserModel;
import com.senai.rastreadorpet.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade  userFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserModel> getAllUsers() {
        List<UserModel> users = userFacade.findAll();
        return userFacade.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel createUser(@RequestBody UserModel user) {
        return userFacade.create(user);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserModel getUserById(@PathVariable int id) {
        return userFacade.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserModel updateUser(@PathVariable int id, @RequestBody UserModel user) {
        return userFacade.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        userFacade.delete(id);
    }

}
