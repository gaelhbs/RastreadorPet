package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
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
}
