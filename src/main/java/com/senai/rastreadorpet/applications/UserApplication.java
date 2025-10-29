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

    // Converte Entity -> Model
    private UserModel toModel(User entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setFullName(entity.getFullName());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setPhone(entity.getPhone());
        model.setPostalCode(entity.getPostalCode());
        model.setStreet(entity.getStreet());
        model.setNumber(entity.getNumber());
        model.setComplement(entity.getComplement());
        model.setNeighborhood(entity.getNeighborhood());
        model.setCity(entity.getCity());
        model.setState(entity.getState());
        model.setRegistrationDate(entity.getRegistrationDate());
        model.setRole(entity.getRole());
        model.setPrivacyConsentDate(entity.getPrivacyConsentDate());
        model.setPreferences(entity.getPreferences());
        model.setPets(entity.getPets());
        model.setSubscriptions(entity.getSubscriptions());
        model.setReceipts(entity.getReceipts());
        model.setGeofences(entity.getGeofences());
        return model;
    }

    // Converte Model -> Entity
    private User toEntity(UserModel model) {
        User entity = new User();
        entity.setId(model.getId());
        entity.setFullName(model.getFullName());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setPhone(model.getPhone());
        entity.setPostalCode(model.getPostalCode());
        entity.setStreet(model.getStreet());
        entity.setNumber(model.getNumber());
        entity.setComplement(model.getComplement());
        entity.setNeighborhood(model.getNeighborhood());
        entity.setCity(model.getCity());
        entity.setState(model.getState());
        entity.setRegistrationDate(model.getRegistrationDate());
        entity.setRole(model.getRole());
        entity.setPrivacyConsentDate(model.getPrivacyConsentDate());
        entity.setPreferences(model.getPreferences());
        entity.setPets(model.getPets());
        entity.setSubscriptions(model.getSubscriptions());
        entity.setReceipts(model.getReceipts());
        entity.setGeofences(model.getGeofences());
        return entity;
    }

    public User create(User entity) {
        UserModel saved = userRepository.save(toModel(entity));
        return toEntity(saved);
    }

    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public User findById(int id) {
        return userRepository.findById(id)
                .map(this::toEntity)
                .orElse(null);
    }

    public User update(int id, User entity) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        entity.setId(id);
        UserModel updated = userRepository.save(toModel(entity));
        return toEntity(updated);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}