package com.senai.rastreadorpet.models;

import lombok.*;
import java.util.Date;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class AssinaturaModel {

        private Long id;
        private String tipoPlano;
        private Double valor;
        private Date dataInicio;
        private Date dataFim;
    }
