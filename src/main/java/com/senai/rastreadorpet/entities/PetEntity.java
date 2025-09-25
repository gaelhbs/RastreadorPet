package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.enums.PetGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetEntity {
    private int id;
    private String name;
    private String species;
    private String breed;
    private LocalDate birthDate;
    private PetGender gender;
    private String photoUrl;

}
