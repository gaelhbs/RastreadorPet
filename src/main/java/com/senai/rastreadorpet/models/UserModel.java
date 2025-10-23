package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.CustomerRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_full_name", nullable = false)
    private String fullName;

    @Column(name = "customer_email", unique = true, nullable = false)
    private String email;

    @Column(name = "customer_password", nullable = false)
    private String password;

    @Column(name = "customer_phone")
    private String phone;

    @Column(name = "customer_postal_code")
    private String postalCode;

    @Column(name = "customer_street")
    private String street;

    @Column(name = "customer_number")
    private String number;

    @Column(name = "customer_complement")
    private String complement;

    @Column(name = "customer_neighborhood")
    private String neighborhood;

    @Column(name = "customer_city")
    private String city;

    @Column(name = "customer_state")
    private String state;

    @Column(name = "customer_registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_role", nullable = false)
    private CustomerRole role;

    @Column(name = "customer_privacy_consent_date")
    private LocalDateTime privacyConsentDate;

    @Column(name = "customer_preferences", columnDefinition = "json")
    private String preferences;
}
