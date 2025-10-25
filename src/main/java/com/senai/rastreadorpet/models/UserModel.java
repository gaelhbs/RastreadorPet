package com.senai.rastreadorpet.models;

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
@Entity
@Table(name = "customers")
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

    // Um usuário pode ter vários pets
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<PetModel> pets = new ArrayList<>();

    // Um usuário pode ter várias assinaturas - Eu acho que aqui é ManyToMany, com a tabela intermediária sendo assinaturas
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<SubscriptionModel> subscriptions = new ArrayList<>();

    // Um usuário pode ter várias recebimentos
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<ReceiptModel> receipts = new ArrayList<>();

    // Um usuário pode ter várias cercas eletrônicas
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<GeofenceModel> geofences = new ArrayList<>();



}
