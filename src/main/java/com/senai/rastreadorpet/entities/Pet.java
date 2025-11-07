package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.AlertModel;
import com.senai.rastreadorpet.models.PaymentMethodModel;
import com.senai.rastreadorpet.models.PetModel;
import com.senai.rastreadorpet.models.enums.PetGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    private String name;
    private String species;
    private String breed;
    private LocalDate birthDate;
    private PetGender gender;
    private String photoUrl;
    private int userId;
    private int deviceId;


    public PetModel toModel() {
        return new PetModel(
                this.id,
                this.name,
                this.species,
                this.breed,
                this.birthDate,
                this.gender,
                this.photoUrl,
                this.userId,
                this.deviceId,
                null,
                null
        );
    }

    public static Pet fromModel(PetModel model) {
        return new Pet(
                model.getId(),
                model.getName(),
                model.getSpecies(),
                model.getBreed(),
                model.getBirthDate(),
                model.getGender(),
                model.getPhotoUrl(),
                model.getUserId(),
                model.getDeviceId()
        );
    }
}
