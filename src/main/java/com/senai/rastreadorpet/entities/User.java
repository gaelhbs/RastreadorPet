package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.GeofenceModel;
import com.senai.rastreadorpet.models.PetModel;
import com.senai.rastreadorpet.models.ReceiptModel;
import com.senai.rastreadorpet.models.SubscriptionModel;
import com.senai.rastreadorpet.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private List<GeofenceModel> geofences = new ArrayList<>();
    private List<ReceiptModel> receipts = new ArrayList<>();
    private List<SubscriptionModel> subscriptions = new ArrayList<>();
    private List<PetModel> pets = new ArrayList<>();
}
