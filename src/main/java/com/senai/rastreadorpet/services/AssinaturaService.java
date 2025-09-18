package com.senai.rastreadorpet.services;

import com.senai.rastreadorpet.models.Assinatura;
import com.senai.rastreadorpet.repositories.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public Assinatura salvar(Assinatura assinatura) {
      
        return assinaturaRepository.save(assinatura);
    }
}
