package com.senai.rastreadorpet.models;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecebimentoModel {
    private Long id;
    private Double valor;
    private String status;
    private Date dataPagamento;
}
