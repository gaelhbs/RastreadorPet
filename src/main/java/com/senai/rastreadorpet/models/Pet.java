package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.PetGenero;
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
    private String nome;

    @Column(name = "pet_especie")
    private String especie;

    @Column(name = "pet_raca")
    private String raca;

    @Column(name = "pet_data_nascimento")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_genero")
    private PetGenero genero;

    @Column(name = "pet_url_foto")
    private String urlFoto;

    public int getId() {
        return id;
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public PetGenero getGenero() {
        return genero;
    }

    public void setGenero(PetGenero genero) {
        this.genero = genero;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
