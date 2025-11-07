package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.User;
import com.senai.rastreadorpet.models.UserModel;
import com.senai.rastreadorpet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserApplication {

    private final UserRepository userRepository;

    public User create(User entity) {
        UserModel saved = userRepository.save(entity.toModel());
        return User.fromModel(saved);
    }

    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(User::fromModel)
                .collect(Collectors.toList());
    }

    public User findById(int id) {
        return userRepository.findById(id)
                .map(User::fromModel)
                .orElse(null);
    }

    public User update(int id, User entity) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        UserModel updated = userRepository.save(entity.toModel());
        return User.fromModel(updated);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}