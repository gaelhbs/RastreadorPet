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
@Table(name = "clientes")
public class User {
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

}
