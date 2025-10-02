package com.senai.rastreadorpet.facade;

import com.senai.rastreadorpet.applications.AssinaturaApplication;
import com.senai.rastreadorpet.entities.AssinaaturaEntity;
import com.senai.rastreadorpet.models.AssinaturaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AssinaturaFacade extends AssinaaturaEntity {

    private AssinaturaApplication application;

    public AssinaturaFacade(Long id, String tipoPlano, Double valor, Date dataInicio, Date dataFim) {

    }

    public AssinaturaModel create(AssinaturaModel model) {
        return application.create(model);
    }

    public List<AssinaturaModel> findAll() {
        return application.findAll();
    }

    public AssinaturaModel findById(Long id) {
        return application.findById(id);
    }

    public AssinaturaModel update(Long id, AssinaturaModel model) {
        return application.update(id, model);
    }

    public void delete(Long id) {
        application.delete(id);
    }
}
