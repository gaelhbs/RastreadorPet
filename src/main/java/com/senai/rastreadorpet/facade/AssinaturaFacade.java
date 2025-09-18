package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.models.Assinatura;
import com.senai.rastreadorpet.services.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssinaturaFacade {

    @Autowired
    private AssinaturaService assinaturaService;

    public Assinatura criarNovaAssinatura(Assinatura assinatura) {
        return assinaturaService.salvar(assinatura);
    }

    public Assinatura cancelarAssinatura(int assinaturaId) {
        return assinaturaService.cancelar(assinaturaId);
    }

    public Assinatura reativarAssinatura(int assinaturaId) {
        return assinaturaService.reativar(assinaturaId);
    }
}
