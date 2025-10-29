package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.rastreadorpet.models.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_full_name", nullable = false)
    private String fullName;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_postal_code")
    private String postalCode;

    @Column(name = "user_street")
    private String street;

    @Column(name = "user_number")
    private String number;

    @Column(name = "user_complement")
    private String complement;

    @Column(name = "user_neighborhood")
    private String neighborhood;

    @Column(name = "user_city")
    private String city;

    @Column(name = "user_state")
    private String state;

    @Column(name = "user_registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;

    @Column(name = "user_privacy_consent_date")
    private LocalDateTime privacyConsentDate;

    @Column(name = "user_preferences", columnDefinition = "json")
    private String preferences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PetModel> pets = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SubscriptionModel> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReceiptModel> receipts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GeofenceModel> geofences = new ArrayList<>();



}
