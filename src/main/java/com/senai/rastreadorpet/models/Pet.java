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

}
