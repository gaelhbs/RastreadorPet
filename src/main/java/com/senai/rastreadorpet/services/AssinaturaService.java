package com.senai.rastreadorpet.services;

import com.senai.rastreadorpet.models.Assinatura;
import com.senai.rastreadorpet.models.enums.AssinaturaStatus;
import com.senai.rastreadorpet.repositories.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public Assinatura salvar(Assinatura assinatura) {
        assinatura.setStatus(AssinaturaStatus.ATIVA);
        return assinaturaRepository.save(assinatura);
    }

    public Assinatura cancelar(int id) {
        Assinatura assinatura = assinaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assinatura com ID " + id + " não encontrada."));

        assinatura.setStatus(AssinaturaStatus.CANCELADA);
        assinatura.setDataFim(LocalDate.now());

        return assinaturaRepository.save(assinatura);
    }

    public Assinatura reativar(int id) {
        Assinatura assinatura = assinaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assinatura com ID " + id + " não encontrada."));

        if (assinatura.getStatus() == AssinaturaStatus.ATIVA) {
            throw new IllegalStateException("A assinatura já está ativa.");
        }

        assinatura.setStatus(AssinaturaStatus.ATIVA);
        assinatura.setDataFim(null);

        return assinaturaRepository.save(assinatura);
    }
}
