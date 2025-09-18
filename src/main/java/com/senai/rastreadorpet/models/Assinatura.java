package com.senai.rastreadorpet.models;

import com.senai.rastreadorpet.models.enums.AssinaturaStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assinaturas")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assinatura_id")
    private int id;

    @Column(name = "assinatura_data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "assinatura_data_fim")
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    @Column(name = "assinatura_status", nullable = false)
    private AssinaturaStatus status;
  
    public int getId() {
        return id;
    }
  
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public AssinaturaStatus getStatus() {
        return status;
    }

    public void setStatus(AssinaturaStatus status) {
        this.status = status;
    }
}
