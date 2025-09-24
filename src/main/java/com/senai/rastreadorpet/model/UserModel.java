package com.senai.rastreadorpet.model;

import com.senai.rastreadorpet.entities.enums.CustomerRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Setter
public class UserModel {
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
    private CustomerRole role;
    private LocalDateTime privacyConsentDate;
    private String preferences;
}
