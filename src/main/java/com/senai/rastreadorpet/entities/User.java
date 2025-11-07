package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.*;
import com.senai.rastreadorpet.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class User {

    private int id;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String postalCode;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private LocalDateTime registrationDate;
    private UserRole role;
    private LocalDateTime privacyConsentDate;
    private String preferences;
    private List<DeviceModel> devices = new ArrayList<>();
    private List<PetModel> pets = new ArrayList<>();
    private List<SubscriptionModel> subscriptions = new ArrayList<>();
    private List<ReceiptModel> receipts = new ArrayList<>();

    public UserModel toModel() {
        UserModel m = new UserModel();
        m.setId(this.id);
        m.setFullName(this.fullName);
        m.setEmail(this.email);
        m.setPassword(this.password);
        m.setPhone(this.phone);
        m.setPostalCode(this.postalCode);
        m.setStreet(this.street);
        m.setNumber(this.number);
        m.setComplement(this.complement);
        m.setNeighborhood(this.neighborhood);
        m.setCity(this.city);
        m.setState(this.state);
        m.setRegistrationDate(this.registrationDate);
        m.setRole(this.role);
        m.setPrivacyConsentDate(this.privacyConsentDate);
        m.setPreferences(this.preferences);

        if (this.devices != null) m.setDevices(this.devices);
        if (this.pets != null) m.setPets(this.pets);
        if (this.subscriptions != null) m.setSubscriptions(this.subscriptions);
        if (this.receipts != null) m.setReceipts(this.receipts);

        return m;
    }

    public static User fromModel(UserModel model) {
        return new User(
                model.getId(),
                model.getFullName(),
                model.getEmail(),
                model.getPassword(),
                model.getPhone(),
                model.getPostalCode(),
                model.getStreet(),
                model.getNumber(),
                model.getComplement(),
                model.getNeighborhood(),
                model.getCity(),
                model.getState(),
                model.getRegistrationDate(),
                model.getRole(),
                model.getPrivacyConsentDate(),
                model.getPreferences(),
                model.getDevices(),
                model.getPets(),
                model.getSubscriptions(),
                model.getReceipts()
        );
    }
}