package com.senai.rastreadorpet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "recebimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecebimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;
    private String status;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
}
