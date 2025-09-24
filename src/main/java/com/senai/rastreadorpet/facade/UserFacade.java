package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.UserApplication;
import com.senai.rastreadorpet.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserApplication userApplication;

    public UserModel create(UserModel entity) {
        return userApplication.create(entity);
    }

    public List<UserModel> findAll() {
        return userApplication.findAll();
    }

    public UserModel findById(int id) {
        return userApplication.findById(id);
    }

    public UserModel update(int id, UserModel entity) {
        return userApplication.update(id, entity);
    }

    public void delete(int id) {
        userApplication.delete(id);
    }
}
