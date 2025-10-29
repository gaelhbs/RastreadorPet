package com.senai.rastreadorpet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.senai.rastreadorpet.models.enums.PetGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "pets")
public class PetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Column(name = "user_id")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserModel user;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private DeviceModel device;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<AlertModel> alerts = new ArrayList<>();
}
