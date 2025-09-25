package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.UserApplication;
import com.senai.rastreadorpet.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserApplication userApplication;

    public UserEntity create(UserEntity entity) {
        return userApplication.create(entity);
    }

    public List<UserEntity> findAll() {
        return userApplication.findAll();
    }

    public UserEntity findById(int id) {
        return userApplication.findById(id);
    }

    public UserEntity update(int id, UserEntity entity) {
        return userApplication.update(id, entity);
    }

    public void delete(int id) {
        userApplication.delete(id);
    }
}
