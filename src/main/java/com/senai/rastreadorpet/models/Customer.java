package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.CustomerRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "cliente_nome_completo", nullable = false)
    private String fullName;

    @Column(name = "cliente_email", unique = true, nullable = false)
    private String email;

    @Column(name = "cliente_senha", nullable = false)
    private String password;

    @Column(name = "cliente_telefone")
    private String phone;

    @Column(name = "cliente_cep")
    private String postalCode;

    @Column(name = "cliente_rua")
    private String street;

    @Column(name = "cliente_numero")
    private String number;

    @Column(name = "cliente_complemento")
    private String complement;

    @Column(name = "cliente_bairro")
    private String neighborhood;

    @Column(name = "cliente_cidade")
    private String city;

    @Column(name = "cliente_estado")
    private String state;

    @Column(name = "cliente_data_cadastro")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "cliente_role", nullable = false)
    private CustomerRole role;

    @Column(name = "cliente_data_consentimento_privacidade")
    private LocalDateTime privacyConsentDate;

    @Column(name = "cliente_preferencias", columnDefinition = "json")
    private String preferences;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public CustomerRole getRole() {
        return role;
    }

    public void setRole(CustomerRole role) {
        this.role = role;
    }

    public LocalDateTime getPrivacyConsentDate() {
        return privacyConsentDate;
    }

    public void setPrivacyConsentDate(LocalDateTime privacyConsentDate) {
        this.privacyConsentDate = privacyConsentDate;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
