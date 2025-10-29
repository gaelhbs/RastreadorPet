package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.UserApplication;
import com.senai.rastreadorpet.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserApplication userApplication;

    public User create(User entity) {
        return userApplication.create(entity);
    }

    public List<User> findAll() {
        return userApplication.findAll();
    }

    public User findById(int id) {
        return userApplication.findById(id);
    }

    public User update(int id, User entity) {
        return userApplication.update(id, entity);
    }

    public void delete(int id) {
        userApplication.delete(id);
    }
}
