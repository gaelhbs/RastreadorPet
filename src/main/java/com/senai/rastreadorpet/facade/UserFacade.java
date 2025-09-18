package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.UserApplication;
import com.senai.rastreadorpet.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserApplication userApplication;

    public User save(User user) {
        return userApplication.save(user);
    }

    public List<User> findAll() {
        return userApplication.findAll();
    }
}
