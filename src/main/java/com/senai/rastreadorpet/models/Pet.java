package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.PetGender;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private int id;

    @Column(name = "pet_nome", nullable = false)
    private String name;

    @Column(name = "pet_especie")
    private String species;

    @Column(name = "pet_raca")
    private String breed;

    @Column(name = "pet_data_nascimento")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_genero")
    private PetGender gender;

    @Column(name = "pet_url_foto")
    private String photoUrl;

    // Getters and Setters

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetGender getGender() {
        return gender;
    }

    public void setGender(PetGender gender) {
        this.gender = gender;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
