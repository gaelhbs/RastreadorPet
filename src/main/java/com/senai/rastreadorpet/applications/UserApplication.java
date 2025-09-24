package com.senai.rastreadorpet.applications;

import com.senai.rastreadorpet.entities.User;
import com.senai.rastreadorpet.model.UserModel;
import com.senai.rastreadorpet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserApplication {

    private final UserRepository userRepository;

    //TODO: SEPARAR EM CLASSE DE MAPPER

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
        return model;
    }

    //TODO: SEPARAR EM CLASSE DE MAPPER

    // Converte Model -> Entity
    private User toEntity(UserModel userModel) {
        User entity = new User();
        entity.setId(userModel.getId());
        entity.setFullName(userModel.getFullName());
        entity.setEmail(userModel.getEmail());
        entity.setPassword(userModel.getPassword());
        entity.setPhone(userModel.getPhone());
        entity.setPostalCode(userModel.getPostalCode());
        entity.setStreet(userModel.getStreet());
        entity.setNumber(userModel.getNumber());
        entity.setComplement(userModel.getComplement());
        entity.setNeighborhood(userModel.getNeighborhood());
        entity.setCity(userModel.getCity());
        entity.setState(userModel.getState());
        entity.setRegistrationDate(userModel.getRegistrationDate());
        entity.setRole(userModel.getRole());
        entity.setPrivacyConsentDate(userModel.getPrivacyConsentDate());
        entity.setPreferences(userModel.getPreferences());
        return entity;
    }

    // CREATE
    public UserModel create(UserModel model) {
        User saved = userRepository.save(toEntity(model));
        return toModel(saved);
    }

    // READ
    public List<UserModel> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    // READ
    public UserModel findById(int id) {
        return userRepository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    // UPDATE
    public UserModel update(int id, UserModel model) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        model.setId(id);
        User updated = userRepository.save(toEntity(model));
        return toModel(updated);
    }

    // DELETE
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
