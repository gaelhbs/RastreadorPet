package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.AssinaturaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "assinaturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssinaaturaEntity extends AssinaturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoPlano; // Ex: "premium" ou "normal"
    private Double valor;
    private Date dataInicio;
    private Date dataFim;
}
