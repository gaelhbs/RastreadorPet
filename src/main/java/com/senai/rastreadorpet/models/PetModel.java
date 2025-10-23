package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.PetGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class PetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private int id;

    @Column(name = "pet_name", nullable = false)
    private String name;

    @Column(name = "pet_species")
    private String species;

    @Column(name = "pet_breed")
    private String breed;

    @Column(name = "pet_birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_gender")
    private PetGender gender;

    @Column(name = "pet_photo_url")
    private String photoUrl;

}
